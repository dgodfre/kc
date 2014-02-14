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
package org.kuali.kra.committee.web.struts.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.kuali.coeus.common.protocol.impl.actions.print.CorrespondencePrintOption;
import org.kuali.coeus.common.protocol.impl.committee.CommitteeBase;
import org.kuali.coeus.common.protocol.impl.committee.CommitteeServiceBase;
import org.kuali.coeus.common.protocol.impl.committee.membership.CommitteeMembershipBase;
import org.kuali.coeus.common.protocol.impl.committee.membership.CommitteeMembershipExpertiseBase;
import org.kuali.coeus.common.protocol.impl.committee.schedule.CommitteeScheduleBase;
import org.kuali.coeus.common.protocol.impl.committee.schedule.CommitteeScheduleServiceBase;
import org.kuali.coeus.common.protocol.impl.committee.schedule.task.CommitteeScheduleTaskBase;
import org.kuali.coeus.common.protocol.impl.committee.task.CommitteeTaskBase;
import org.kuali.coeus.common.protocol.impl.committee.web.struts.form.CommitteeHelperBase;
import org.kuali.coeus.common.protocol.impl.correspondence.CorrespondenceTypeModuleIdConstants;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeMembership;
import org.kuali.kra.committee.bo.CommitteeMembershipExpertise;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.committee.document.authorization.CommitteeScheduleTask;
import org.kuali.kra.committee.service.CommitteeScheduleService;
import org.kuali.kra.committee.service.CommitteeService;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.irb.correspondence.ProtocolCorrespondenceType;
import org.kuali.rice.krad.service.BusinessObjectService;

/**
 * The CommitteeHelper corresponds to the Committee tab web page.
 */
public class CommitteeHelper extends CommitteeHelperBase {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1690627670210310054L;

    public CommitteeHelper(CommitteeForm committeeForm) {
        super(committeeForm);
    }

    @Override
    protected CommitteeMembershipBase getNewCommitteeMembershipInstanceHook() {
        return new CommitteeMembership();
    }

    @Override
    protected Class<? extends CommitteeScheduleServiceBase> getCommitteeScheduleServiceClassHook() {
        return CommitteeScheduleService.class;
    }

    @Override
    protected Class<? extends CommitteeServiceBase> getCommitteeServiceClassHook() {
        return CommitteeService.class;
    }

    @Override
    protected CommitteeMembershipExpertiseBase getNewCommitteeMembershipExpertiseInstanceHook() {
        return new CommitteeMembershipExpertise();
    }

    @Override
    protected CommitteeScheduleTaskBase getNewCommitteeScheduleTaskInstanceHook(String taskName, CommitteeBase committee, CommitteeScheduleBase committeeSchedule) {
        return new CommitteeScheduleTask(taskName, (Committee) committee, (CommitteeSchedule) committeeSchedule);
    }

    @Override
    protected CommitteeTaskBase getNewCommitteeTaskInstanceHook(String taskName, CommitteeBase committee) {
        // creating an anonymous class to avoid task hierarchy issues
        return new CommitteeTaskBase<Committee>(TaskGroupName.COMMITTEE, taskName, (Committee) committee) {};
    }

    @Override
    protected void initPrintCorrespondences() {
        List<CorrespondencePrintOption> printOptions = new ArrayList<CorrespondencePrintOption>();
        Map<String, Object> values = new HashMap<String, Object>();
        List<ProtocolCorrespondenceType> correspondenceTypes = (List<ProtocolCorrespondenceType>)
                KraServiceLocator.getService(BusinessObjectService.class).findMatching(ProtocolCorrespondenceType.class,values);
        for(ProtocolCorrespondenceType correspondenceType : correspondenceTypes) {
            if(StringUtils.equals(correspondenceType.getModuleId(),CorrespondenceTypeModuleIdConstants.COMMITTEE.getCode())) {
                CorrespondencePrintOption printOption = new CorrespondencePrintOption();
                printOption.setDescription(correspondenceType.getDescription());
                printOption.setLabel(correspondenceType.getDescription());
                printOption.setCorrespondenceId(1L);
                printOption.setProtocolCorrespondenceTemplate(correspondenceType.getDefaultProtocolCorrespondenceTemplate());
                printOptions.add(printOption);
            }
        }
        setCorrespondencesToPrint(printOptions);
    }
}
