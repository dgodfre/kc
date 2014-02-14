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
package org.kuali.coeus.common.protocol.impl.actions.abandon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.coeus.common.protocol.impl.ProtocolBase;
import org.kuali.coeus.common.protocol.impl.actions.ProtocolActionBase;
import org.kuali.coeus.common.protocol.impl.actions.correspondence.ProtocolActionCorrespondenceGenerationService;
import org.kuali.coeus.common.protocol.impl.actions.correspondence.ProtocolActionsCorrespondenceBase;
import org.kuali.coeus.common.protocol.impl.actions.genericactions.ProtocolGenericActionBean;
import org.kuali.coeus.common.protocol.impl.actions.submit.ProtocolActionService;
import org.kuali.kra.printing.PrintingException;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class ProtocolAbandonServiceImplBase implements ProtocolAbandonService {

    private static final Log LOG = LogFactory.getLog(ProtocolAbandonServiceImplBase.class);
    
    @Autowired
    @Qualifier("documentService")
    private DocumentService documentService;
    
    private ProtocolActionService protocolActionService;
    
    private ProtocolActionCorrespondenceGenerationService protocolActionCorrespondenceGenerationService;


    public void abandonProtocol(ProtocolBase protocol, ProtocolGenericActionBean protocolAbandonBean) throws WorkflowException {

        ProtocolActionBase protocolAction = getNewActionHook(protocol); 
        protocolAction.setComments(protocolAbandonBean.getComments());
        protocol.getProtocolActions().add(protocolAction);
        protocolActionService.updateProtocolStatus(protocolAction, protocol);
        protocol.setActive(false);
        documentService.cancelDocument(protocol.getProtocolDocument(), null);
        
    }

    protected abstract String getActionType();
    
    public abstract ProtocolActionBase getNewActionHook(ProtocolBase protocol);
    
    protected abstract ProtocolActionsCorrespondenceBase getNewProtocolCorrespondenceHook(String actionType);
    
    private void createCorrespondenceAndAttach(ProtocolBase protocol, String protocolActionType) throws PrintingException {
        ProtocolActionsCorrespondenceBase correspondence = getNewProtocolCorrespondenceHook(protocolActionType);
        correspondence.setPrintableBusinessObject(protocol);
        correspondence.setProtocol(protocol);
        protocolActionCorrespondenceGenerationService.generateCorrespondenceDocumentAndAttach(correspondence);
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public void setProtocolActionService(ProtocolActionService protocolActionService) {
        this.protocolActionService = protocolActionService;
    }

    public void setProtocolActionCorrespondenceGenerationService(
            ProtocolActionCorrespondenceGenerationService protocolActionCorrespondenceGenerationService) {
        this.protocolActionCorrespondenceGenerationService = protocolActionCorrespondenceGenerationService;
    }


}
