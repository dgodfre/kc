/*
 * Copyright 2005-2014 The Kuali Foundation.
 * 
 * Licensed under the Educational Community License, Version 1.0 (the "License");
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
package org.kuali.kra.s2s.polling;

/**
 * 
 * This interface is used to store all information related to a schedulable job
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface TaskInfo {
    /**
     *return task id
     */
    public String getTaskId();
    /**
     *return delay in minutes
     */
    public long getDelayToStart();
    /**
     *return interval in minutes
     */
    public long getPollingInterval();
}
