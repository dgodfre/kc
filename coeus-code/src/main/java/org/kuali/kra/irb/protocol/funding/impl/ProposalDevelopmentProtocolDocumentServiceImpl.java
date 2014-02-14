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
package org.kuali.kra.irb.protocol.funding.impl;

import org.kuali.coeus.common.protocol.impl.ProtocolBase;
import org.kuali.coeus.common.protocol.impl.actions.submit.ProtocolSubmissionBase;
import org.kuali.coeus.common.protocol.impl.personnel.ProtocolPersonBase;
import org.kuali.coeus.common.protocol.impl.personnel.ProtocolPersonnelService;
import org.kuali.coeus.common.protocol.impl.protocol.funding.impl.ProposalDevelopmentProtocolDocumentServiceImplBase;
import org.kuali.kra.iacuc.protocol.funding.IacucProtocolFundingSourceService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.infrastructure.RoleConstants;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.personnel.ProtocolPerson;
import org.kuali.kra.irb.protocol.ProtocolNumberService;
import org.kuali.kra.irb.protocol.funding.ProposalDevelopmentProtocolDocumentService;
import org.kuali.kra.irb.protocol.funding.ProtocolFundingSourceService;
import org.kuali.kra.proposaldevelopment.document.authorization.ProposalTask;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.DocumentService;

/**
 * 
 * This service creates Proposal Development Document from Protocol for users authorized to create proposal. This created
 * proposal is then added to Protocol Funding sources. 
 */
public class ProposalDevelopmentProtocolDocumentServiceImpl 
        extends ProposalDevelopmentProtocolDocumentServiceImplBase<ProtocolDocument> 
        implements ProposalDevelopmentProtocolDocumentService {
    
    private ProtocolNumberService protocolNumberService;
    private ProtocolPersonnelService protocolPersonnelService;
    private ProtocolFundingSourceService protocolFundingSourceService;

    protected static final String PROTOCOL_CREATED = "Protocol created";
    protected static final String DEFAULT_PROTOCOL_TYPE = "1";
    
    @Override
    protected ProtocolDocument getProtocolDocumentNewInstanceHook(DocumentService documentService) throws WorkflowException
    {
        return (ProtocolDocument) documentService.getNewDocument(ProtocolDocument.class);
    }
    
    @Override
    protected ProtocolNumberService getProtocolNumberServiceHook() {
        return getProtocolNumberService();
    }

    @Override
    protected String getProtocolActionProtocolCreatedCodeHook() {
        return ProtocolActionType.PROTOCOL_CREATED;
    }

    @Override
    protected ProtocolAction getProtocolActionNewInstanceHook(ProtocolBase protocol, ProtocolSubmissionBase protocolSubmission,
            String protocolActionTypeCode) {
        return new ProtocolAction((Protocol) protocol, (ProtocolSubmission) protocolSubmission, protocolActionTypeCode);
    }

    @Override
    protected String getProtocolAggregatorHook() {
        return RoleConstants.PROTOCOL_AGGREGATOR;
    }

    @Override
    protected String getProtocolApproverHook() {
        return RoleConstants.PROTOCOL_APPROVER;
    }

    @Override
    protected String getProtocolRoleTypeHook() {
        return RoleConstants.PROTOCOL_ROLE_TYPE;
    }

    @Override
    protected String getProtocolNameSpaceHook() {
        return Constants.MODULE_NAMESPACE_PROTOCOL;
    }

    @Override
    protected String getProtocolCreatedHook() {
        return PROTOCOL_CREATED;
    }

    @Override
    protected String getSequenceNumberNameHook() {
        return "SEQ_IACUC_PROTOCOL_ID";
    }
    
    protected String getCreateProposalTaskNameHook() {
        return ProposalTask.CREATE_IRB_PROTOCOL_FROM_PROPOSAL;
    }

    @Override
    protected ProtocolPersonBase getProtocolPersonNewInstanceHook() {
        return new ProtocolPerson();
    }

    @Override
    protected ProtocolPersonnelService getProtocolPersonnelServiceHook() {
        return getProtocolPersonnelService();
    }

    @Override
    protected ProtocolFundingSourceService getProtocolFundingSourceServiceHook() {
        return getProtocolFundingSourceService(); 
    }

    @Override
    protected String getProtocolTypeCodeHook() {
        return DEFAULT_PROTOCOL_TYPE;
    }

    @Override
    protected void populateProtocolSpecificFieldsHook(ProtocolBase protocol) {

    }

    protected ProtocolNumberService getProtocolNumberService() {
        return protocolNumberService;
    }

    public void setProtocolNumberService(ProtocolNumberService protocolNumberService) {
        this.protocolNumberService = protocolNumberService;
    }

    protected ProtocolPersonnelService getProtocolPersonnelService() {
        return protocolPersonnelService;
    }

    public void setProtocolPersonnelService(ProtocolPersonnelService protocolPersonnelService) {
        this.protocolPersonnelService = protocolPersonnelService;
    }

    protected ProtocolFundingSourceService getProtocolFundingSourceService() {
        if (protocolFundingSourceService == null) {
            protocolFundingSourceService = KraServiceLocator.getService(ProtocolFundingSourceService.class);
        }
        return protocolFundingSourceService;
    }

    public void setProtocolFundingSourceService(ProtocolFundingSourceService protocolFundingSourceService) {
        this.protocolFundingSourceService = protocolFundingSourceService;
    }

}