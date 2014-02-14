/*
 * Copyright 2005-2013 The Kuali Foundation
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
package org.kuali.kra.iacuc.auth;

import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * Is the user allowed to administratively correct a protocol?
 */
public class IacucUndoLastActionProtocolAuthorizer extends IacucProtocolAuthorizer {

    /**
     * @see org.kuali.coeus.common.protocol.impl.auth.ProtocolAuthorizer#isAuthorized(java.lang.String, org.kuali.coeus.common.protocol.impl.auth.ProtocolTask)
     */
    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        return hasPermission(userId, task.getProtocol(), PermissionConstants.PERFORM_IACUC_ACTIONS_ON_PROTO);
    }
}
