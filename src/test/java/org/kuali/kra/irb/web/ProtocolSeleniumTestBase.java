/*
 * Copyright 2005-2010 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.osedu.org/licenses/ECL-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kra.irb.web;

import org.kuali.kra.test.infrastructure.KcSeleniumTestBase;

/**
 * Base class for all integration tests for Protocols.
 */
public class ProtocolSeleniumTestBase extends KcSeleniumTestBase {
    
    private static final String PAGE_TITLE = "Kuali :: KC Protocol";
    
    private static final String CREATE_PROTOCOL_LINK_NAME = "Create Protocol";
    private static final String PROTOCOL_LINK_NAME = "protocol";
    private static final String PERSONNEL_LINK_NAME = "personnel";
    private static final String QUESTIONNAIRE_LINK_NAME = "questionnaire";
    private static final String CUSTOM_DATA_LINK_NAME = "customData";
    private static final String SPECIAL_REVIEW_LINK_NAME = "specialReview";
    private static final String PERMISSIONS_LINK_NAME = "permissions";
    private static final String NOTES_AND_ATTACHMENTS_LINK_NAME = "noteAndAttachment";
    private static final String PROTOCOL_ACTIONS_LINK_NAME = "protocolActions";
    
    private static final String PERSON_ID_TAG = "protocolHelper.personId";
    
    private static final String DOCUMENT_DESCRIPTION_ID = "document.documentHeader.documentDescription";
    private static final String LIST_PREFIX = "document.protocolList[0].";
    private static final String TYPE_CODE_ID = LIST_PREFIX + "protocolTypeCode";
    private static final String TITLE_ID = LIST_PREFIX + "title";
    private static final String PERSON_ID = "personId";
    private static final String SUBMISSION_TYPE_CODE_ID = "actionHelper.protocolSubmitAction.submissionTypeCode";
    private static final String REVIEW_TYPE_CODE_ID = "actionHelper.protocolSubmitAction.protocolReviewTypeCode";
    
    private static final String DEFAULT_DOCUMENT_DESCRIPTION = "Protocol Document";
    private static final String DEFAULT_TYPE_CODE = "Standard";
    private static final String DEFAULT_TITLE = "New protocol test";
    private static final String DEFAULT_PERSON_ID = "10000000004";
    private static final String DEFAULT_SUBMISSION_TYPE = "Initial Protocol Application for Approval";
    private static final String DEFAULT_SUBMISSION_REVIEW_TYPE = "Full";
    
    private static final String SUBMIT_FOR_REVIEW_BUTTON = "methodToCall.submitForReview";
    
    /**
     * Creates a new instance of the Protocol page, filling in all required values, and saving.
     */
    protected final void createProtocol() {
        clickResearcherTab();
        
        click(CREATE_PROTOCOL_LINK_NAME);
        assertTitleContains(PAGE_TITLE);
        
        setDefaultRequiredFields();
        
        saveDocument();
        assertSave();
    }
    
    
    /**
     * Submits an already created Protocol and returns to the Protocol Action page.
     */
    protected final void submitProtocol() throws Exception {
        clickProtocolActionsPage();
        
        setSubmissionRequiredFields();
        
        click(SUBMIT_FOR_REVIEW_BUTTON);
        assertRoute();
    }

    /**
     * Sets the Protocol's required fields to legal default values.
     */
    protected void setDefaultRequiredFields(){
        set(DOCUMENT_DESCRIPTION_ID, DEFAULT_DOCUMENT_DESCRIPTION);
        set(TYPE_CODE_ID, DEFAULT_TYPE_CODE);
        set(TITLE_ID, DEFAULT_TITLE);
        lookup(PERSON_ID_TAG, PERSON_ID, DEFAULT_PERSON_ID);
    }
    
    /**
     * Sets the Protocol's submission fields to legal default values.
     */
    protected void setSubmissionRequiredFields() {
        clickExpandAll();
        
        set(SUBMISSION_TYPE_CODE_ID, DEFAULT_SUBMISSION_TYPE);
        set(REVIEW_TYPE_CODE_ID, DEFAULT_SUBMISSION_REVIEW_TYPE);
    }
    
    /**
     * Navigate to the Protocol Protocol page.
     */
    protected void clickProtocolProtocolPage() {
        click(PROTOCOL_LINK_NAME);
    }
    
    /**
     * Navigate to the Protocol Personnel page.
     */
    protected void clickProtocolPersonnelPage() {
        click(PERSONNEL_LINK_NAME);
    }
    
    /**
     * Navigate to the Protocol Questionnaire page.
     */
    protected void clickProtocolQuestionnairePage() {
        click(QUESTIONNAIRE_LINK_NAME);
    }
    
    /**
     * Navigate to the Protocol Custom Data page.
     */
    protected void clickProtocolCustomDataPage() {
        click(CUSTOM_DATA_LINK_NAME);
    }
    
    /**
     * Navigate to the Protocol Special Review page.
     */
    protected void clickProtocolSpecialReviewPage() {
        click(SPECIAL_REVIEW_LINK_NAME);
    }
    
    /**
     * Navigate to the Protocol Permissions page.
     */
    protected void clickProtocolPermissionsPage() {
        click(PERMISSIONS_LINK_NAME);
    }
    
    /**
     * Navigate to the Protocol Notes & Attachments page.
     */
    protected void clickProtocolNotesAndAttachmentsPage() {
        click(NOTES_AND_ATTACHMENTS_LINK_NAME);
    }
    
    /**
     * Navigate to the Protocol Actions page.
     */
    protected void clickProtocolActionsPage() {
        click(PROTOCOL_ACTIONS_LINK_NAME);
    }
    
}