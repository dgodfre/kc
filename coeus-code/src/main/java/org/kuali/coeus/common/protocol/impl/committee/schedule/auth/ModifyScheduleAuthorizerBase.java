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
package org.kuali.coeus.common.protocol.impl.committee.schedule.auth;

import org.kuali.coeus.common.protocol.impl.committee.CommitteeBase;
import org.kuali.coeus.common.protocol.impl.committee.auth.CommitteeAuthorizerBase;
import org.kuali.coeus.common.protocol.impl.committee.task.CommitteeTaskBase;

public abstract class ModifyScheduleAuthorizerBase extends CommitteeAuthorizerBase {

    /**
     * @see org.kuali.coeus.common.protocol.impl.committee.auth.document.authorizer.CommitteeAuthorizerBase#isAuthorized(java.lang.String, org.kuali.coeus.common.protocol.impl.document.authorization.CommitteeTaskBase)
     */
    public boolean isAuthorized(String username, CommitteeTaskBase task) {
        boolean hasPermission = true;
        CommitteeBase committee = task.getCommittee();

        hasPermission = hasPermission(username, committee, getModfifySchedulePermissionNameHook());
        return hasPermission;
    }

    protected abstract String getModfifySchedulePermissionNameHook();

}
