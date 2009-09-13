/*
 * Copyright 2006-2008 The Kuali Foundation
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
package org.kuali.kra.institutionalproposal.service.impl;

import java.util.ArrayList;

import org.kuali.kra.bo.versioning.VersionStatus;
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.exception.InstitutionalProposalCreationException;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.service.InstitutionalProposalService;
import org.kuali.kra.proposaldevelopment.bo.DevelopmentProposal;
import org.kuali.rice.kew.exception.WorkflowException;
import org.kuali.rice.kns.service.DocumentService;
import org.kuali.rice.kns.util.GlobalVariables;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class InstitutionalProposalServiceImpl implements InstitutionalProposalService {
    
    private DocumentService documentService;
    
    public String createInstitutionalProposal(DevelopmentProposal developmentProposal) {
        GlobalVariables.getUserSession().setBackdoorUser("quickstart"); // Should be KC system user
        InstitutionalProposalDocument institutionalProposalDocument;
        try {
            institutionalProposalDocument = (InstitutionalProposalDocument) documentService.getNewDocument(InstitutionalProposalDocument.class);
        } catch (WorkflowException ex) {
            throw new InstitutionalProposalCreationException("Caught workflow exception getting new document", ex);
        } finally {
            resetUserSession();
        }
        
        institutionalProposalDocument.getDocumentHeader().setDocumentDescription(
                "Generated by Dev Proposal" + developmentProposal.getProposalNumber());
        InstitutionalProposal institutionalProposal = new InstitutionalProposal();
        institutionalProposal.setProposalTypeCode(Integer.parseInt(developmentProposal.getProposalTypeCode()));
        institutionalProposal.setActivityTypeCode(developmentProposal.getActivityTypeCode());
        institutionalProposal.setStatusCode(1);  // TODO app constant
        institutionalProposal.setSponsorCode(developmentProposal.getSponsorCode());
        institutionalProposal.setTitle(developmentProposal.getTitle());
        institutionalProposal.setSubcontractFlag(false); // ??
        institutionalProposal.setProposalSequenceStatus(VersionStatus.ACTIVE.toString());
        institutionalProposalDocument.setInstitutionalProposal(institutionalProposal);
        
        try {
            documentService.saveDocument(institutionalProposalDocument);
            documentService.blanketApproveDocument(institutionalProposalDocument, 
                    "System generated Institutional Proposal from Development Proposal" + developmentProposal.getProposalNumber(), 
                    new ArrayList<Object>());
        } catch (WorkflowException ex) {
            throw new InstitutionalProposalCreationException("Caught workflow exception routing new document", ex);
        } finally {
            resetUserSession();
        }
        
        resetUserSession();
        return institutionalProposal.getProposalNumber();
    }
    
    public void createInstutitionalProposalVersion(String proposalNumber, DevelopmentProposal developmentProposal) {
        
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
    
    private void resetUserSession() {
        GlobalVariables.getUserSession().clearBackdoorUser();
    }

}
