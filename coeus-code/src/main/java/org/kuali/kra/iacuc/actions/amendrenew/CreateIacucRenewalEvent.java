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
package org.kuali.kra.iacuc.actions.amendrenew;

import org.kuali.coeus.common.protocol.impl.actions.amendrenew.CreateRenewalEventBase;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.rule.BusinessRuleInterface;

public class CreateIacucRenewalEvent extends CreateRenewalEventBase {

    public CreateIacucRenewalEvent(IacucProtocolDocument document, String propertyName, String renewalSummary) {
        super(document, propertyName, renewalSummary);
    }

    @Override
    public BusinessRuleInterface getRule() {
        return new CreateIacucRenewalRule();
    }

}
