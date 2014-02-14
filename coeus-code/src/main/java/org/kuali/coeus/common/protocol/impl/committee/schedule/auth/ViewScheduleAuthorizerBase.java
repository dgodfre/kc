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
import org.kuali.coeus.common.protocol.impl.committee.schedule.CommitteeScheduleBase;
import org.kuali.coeus.common.protocol.impl.committee.schedule.task.CommitteeScheduleTaskBase;
import org.kuali.coeus.common.protocol.impl.committee.task.CommitteeTaskBase;

public abstract class ViewScheduleAuthorizerBase extends CommitteeAuthorizerBase {

    /**
     * @see org.kuali.coeus.common.protocol.impl.committee.auth.document.authorizer.CommitteeAuthorizerBase#isAuthorized(java.lang.String, org.kuali.coeus.common.protocol.impl.document.authorization.CommitteeTaskBase)
     */
    public boolean isAuthorized(String username, CommitteeTaskBase task) {
        boolean hasPermission = true;
        CommitteeBase committee = task.getCommittee();
        if (task instanceof CommitteeScheduleTaskBase) {
//            hasPermission = hasPermission(username,((CommitteeScheduleTaskBase)task).getCommitteeSchedule(),PermissionConstants.VIEW_IACUC_SCHEDULE);
            hasPermission = hasPermission(username,((CommitteeScheduleTaskBase)task).getCommitteeSchedule(), getPermissionNameForViewScheduleHook());
            // now check if this schedule is flagged as available by admin
            hasPermission = hasPermission && ((CommitteeScheduleTaskBase)task).getCommitteeSchedule().isAvailableToReviewers();
        } else {
            hasPermission = hasPermission(username, committee, getPermissionNameForViewScheduleHook());
        }        
        return hasPermission;
    }

    protected abstract String getPermissionNameForViewScheduleHook();

    /**
     * Does the given user has the permission for this committee?
     * @param username the unique username of the user
     * @param committee the committee
     * @param permissionName the name of the permission
     * @return true if the person has the permission; otherwise false
     */
    protected final boolean hasPermission(String userId, CommitteeScheduleBase committeeSchedule, String permissionName) {
        return kraAuthorizationService.hasPermission(userId, committeeSchedule, permissionName);
    }
    

}
