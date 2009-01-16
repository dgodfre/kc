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
package org.kuali.kra.service;

import java.util.List;

import org.kuali.core.web.ui.KeyLabelPair;
import org.kuali.kra.award.web.struts.form.AwardForm;

/**
 * 
 * This is the AwardReportsService interface.
 */
public interface AwardReportsService {
    
    /**
     * 
     * This method prepares the AwardReportTerm and related objects for the display of UI.
     * @param awardForm
     */
    public void doPreparations(AwardForm awardForm);
    
    public String getFrequencyCodes(String reportClassCode, String reportCode);
    
    public String getFrequencyBaseCodes(String frequencyCode);
    
}
