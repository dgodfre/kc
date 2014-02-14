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
package org.kuali.kra.irb.actions.submit;

import org.apache.commons.logging.Log;
import org.kuali.coeus.common.protocol.impl.ProtocolDocumentBase;
import org.kuali.coeus.common.protocol.impl.actions.submit.ProtocolSubmitAction;
import org.kuali.coeus.common.protocol.impl.actions.submit.ProtocolSubmitActionEventBase;

public class ProtocolSubmitActionEvent extends ProtocolSubmitActionEventBase {
        
    public ProtocolSubmitActionEvent(ProtocolDocumentBase document, ProtocolSubmitAction submitAction) {
        super(document, submitAction);
    }

    private static final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(ProtocolSubmitActionEvent.class);

    @Override
    protected Log getLOGHook() {
        return LOG;
    }
    
}
