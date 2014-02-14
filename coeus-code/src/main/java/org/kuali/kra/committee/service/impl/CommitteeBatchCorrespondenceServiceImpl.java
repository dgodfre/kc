/*
 * Copyright 2005-2013 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.committee.service.impl;

import org.apache.commons.lang.StringUtils;
import org.kuali.coeus.common.protocol.impl.ProtocolBase;
import org.kuali.coeus.common.protocol.impl.actions.ProtocolActionBase;
import org.kuali.coeus.common.protocol.impl.committee.corresp.CommitteeBatchCorrespondenceBase;
import org.kuali.coeus.common.protocol.impl.committee.corresp.CommitteeBatchCorrespondenceDetailBase;
import org.kuali.coeus.common.protocol.impl.committee.corresp.CommitteeBatchCorrespondenceServiceImplBase;
import org.kuali.coeus.common.protocol.impl.correspondence.BatchCorrespondenceBase;
import org.kuali.kra.committee.bo.CommitteeBatchCorrespondence;
import org.kuali.kra.committee.bo.CommitteeBatchCorrespondenceDetail;
import org.kuali.kra.committee.service.CommitteeBatchCorrespondenceService;
import org.kuali.kra.committee.service.CommitteePrintingService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.genericactions.ProtocolGenericActionBean;
import org.kuali.kra.irb.actions.genericactions.ProtocolGenericActionService;
import org.kuali.kra.irb.actions.notification.BatchCorrespondenceNotificationRenderer;
import org.kuali.kra.irb.correspondence.BatchCorrespondence;
import org.kuali.kra.irb.correspondence.ProtocolCorrespondence;
import org.kuali.kra.irb.correspondence.ProtocolCorrespondenceType;
import org.kuali.kra.irb.notification.IRBNotificationContext;

import java.sql.Date;
import java.util.List;

/**
 * 
 * This class generates the batch correspondence of committees.
 */
public class CommitteeBatchCorrespondenceServiceImpl extends CommitteeBatchCorrespondenceServiceImplBase implements CommitteeBatchCorrespondenceService {

    @Override
    /**
     * This method generates the batch correspondence for a committee.
     * @param batchCorrespondenceTypeCode
     * @param startDate
     * @param endDate
     * @return CommitteeBatchCorrespondence
     * @throws Exception 
     */
    public CommitteeBatchCorrespondenceBase generateBatchCorrespondence(String batchCorrespondenceTypeCode, String committeeId, Date startDate, 
            Date endDate) throws Exception {
        BatchCorrespondence batchCorrespondence = null;
        List<? extends ProtocolBase> protocols = null;
        finalActionCounter = 0;

        CommitteeBatchCorrespondence committeeBatchCorrespondence = new CommitteeBatchCorrespondence(batchCorrespondenceTypeCode, 
                committeeId, startDate, endDate);
        
        String protocolActionTypeCode;
        
        if (StringUtils.equals(batchCorrespondenceTypeCode, Constants.PROTOCOL_RENEWAL_REMINDERS)) {
            protocols = protocolDao.getExpiringProtocols(committeeId, startDate, endDate);
            protocolActionTypeCode = Constants.PROTOCOL_ACTION_TYPE_CODE_RENEWAL_REMINDER_GENERATED;
        } else if (StringUtils.equals(batchCorrespondenceTypeCode, Constants.REMINDER_TO_IRB_NOTIFICATIONS)) {
            protocols = protocolDao.getNotifiedProtocols(committeeId, startDate, endDate);
            protocolActionTypeCode = Constants.PROTOCOL_ACTION_TYPE_CODE_IRB_NOTIFICATION_GENERATED;
        } else {
            throw new IllegalArgumentException(batchCorrespondenceTypeCode);
        }

        batchCorrespondence = (BatchCorrespondence) lookupBatchCorrespondence(batchCorrespondenceTypeCode);
        
        for (ProtocolBase protocol : protocols) {
            ProtocolCorrespondenceType protocolCorrespondenceType = (ProtocolCorrespondenceType) getProtocolCorrespondenceTypeToGenerate(protocol, batchCorrespondence);

            if (protocolCorrespondenceType != null)  {
                if (protocolCorrespondenceTemplateService.getProtocolCorrespondenceTemplate(committeeId, 
                        protocolCorrespondenceType.getProtoCorrespTypeCode()) == null) {
                    LOG.warn("Correspondence template \"" + protocolCorrespondenceType.getDescription() + "\" is missing.  Correspondence for protocol " 
                            + protocol.getProtocolNumber() + " has not been generated.  Add the missing template and regenerate correspondence.");
                } else {
                    CommitteeBatchCorrespondenceDetail batchCorrespondenceDetail = (CommitteeBatchCorrespondenceDetail) createBatchCorrespondenceDetail(committeeId, protocol, 
                            protocolCorrespondenceType, committeeBatchCorrespondence.getCommitteeBatchCorrespondenceId(), protocolActionTypeCode);
                    committeeBatchCorrespondence.getCommitteeBatchCorrespondenceDetails().add(batchCorrespondenceDetail);
                    
                    Long detailId = batchCorrespondenceDetail.getCommitteeBatchCorrespondenceDetailId();
                    String description = protocolCorrespondenceType.getDescription();
                    //String userFullName = kcPersonService.getKcPersonByPersonId(GlobalVariables.getUserSession().getPrincipalId()).getFullName();
                    String userFullName = Constants.EMPTY_STRING;
                    BatchCorrespondenceNotificationRenderer renderer 
                        = new BatchCorrespondenceNotificationRenderer((Protocol) protocol, detailId, description, userFullName);
                    IRBNotificationContext context 
                        = new IRBNotificationContext((Protocol) protocol, ProtocolActionType.RENEWAL_REMINDER_GENERATED, "Renewal Reminder Generated", renderer);
                    context.setEmailAttachments(getEmailAttachments(batchCorrespondenceDetail.getProtocolCorrespondence()));
                    kcNotificationService.sendNotification(context);
                }
            }
        }

        businessObjectService.save(committeeBatchCorrespondence);
        
        committeeBatchCorrespondence.setFinalActionCounter(finalActionCounter);
        
        return committeeBatchCorrespondence;
    }

    @Override
    /**
     * This method applies the final action to the protocol.
     * 
     * @param protocol
     * @param batchCorrespondence
     * @throws Exception
     */
    protected void applyFinalAction(ProtocolBase protocol, BatchCorrespondenceBase batchCorrespondence) throws Exception {
        ProtocolGenericActionBean actionBean = new ProtocolGenericActionBean(null, Constants.EMPTY_STRING);
        actionBean.setComments("Final action of batch Correspondence: " + batchCorrespondence.getDescription());
        
        if (StringUtils.equals(ProtocolActionType.SUSPENDED, batchCorrespondence.getFinalActionTypeCode())) {
            try {
                protocol.getProtocolDocument().getDocumentHeader().getWorkflowDocument();
            }
            catch (RuntimeException ex) {
                protocol.setProtocolDocument((ProtocolDocument) documentService.getByDocumentHeaderId(protocol.getProtocolDocument().getDocumentNumber()));
            }
            protocolGenericActionService.suspend((Protocol) protocol, actionBean);
            finalActionCounter++;
        }
        
        if (StringUtils.equals(ProtocolActionType.CLOSED_ADMINISTRATIVELY_CLOSED, batchCorrespondence.getFinalActionTypeCode())) {
            try {
                protocol.getProtocolDocument().getDocumentHeader().getWorkflowDocument();
            }
            catch (RuntimeException ex) {
                protocol.setProtocolDocument((ProtocolDocument) documentService.getByDocumentHeaderId(protocol.getProtocolDocument().getDocumentNumber()));
            }
            ((ProtocolGenericActionService) protocolGenericActionService).close((Protocol) protocol, actionBean);
            finalActionCounter++;
        }
    }
    
    protected CommitteePrintingService getCommitteePrintingService() {
        return KraServiceLocator.getService(CommitteePrintingService.class);
    }
    
    /**
     * Populated by Spring Beans.
     * @param protocolGenericActionService
     */
    public void setProtocolGenericActionService(ProtocolGenericActionService protocolGenericActionService) {
        this.protocolGenericActionService = protocolGenericActionService;
    }

    @Override
    protected Class<? extends org.kuali.coeus.common.protocol.impl.correspondence.ProtocolCorrespondence> getProtocolCorrespondenceBOClassHook() {
        return ProtocolCorrespondence.class;
    }

    @Override
    protected CommitteeBatchCorrespondenceDetailBase getNewCommitteeBatchCorrespondenceDetailInstanceHook() {
        return new CommitteeBatchCorrespondenceDetail();
    }

    @Override
    protected ProtocolActionBase getNewProtocolActionInstanceHook(ProtocolBase protocol, Object object, String protocolActionTypeCode) {
        return new ProtocolAction((Protocol) protocol, null, protocolActionTypeCode);
    }

    @Override
    protected org.kuali.coeus.common.protocol.impl.correspondence.ProtocolCorrespondence getNewProtocolCorrespondenceInstanceHook() {
        return new ProtocolCorrespondence();
    }

    @Override
    protected Class<? extends BatchCorrespondenceBase> getBatchCorrespondenceBOClassHook() {
        return BatchCorrespondence.class;
    }

}
