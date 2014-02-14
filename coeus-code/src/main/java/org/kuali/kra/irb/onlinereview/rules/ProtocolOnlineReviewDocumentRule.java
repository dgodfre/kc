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
package org.kuali.kra.irb.onlinereview.rules;

import org.apache.commons.lang.StringUtils;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReview;
import org.kuali.kra.irb.onlinereview.event.AddProtocolOnlineReviewCommentEvent;
import org.kuali.kra.irb.onlinereview.event.DeleteProtocolOnlineReviewEvent;
import org.kuali.kra.irb.onlinereview.event.DisapproveProtocolOnlineReviewCommentEvent;
import org.kuali.kra.irb.onlinereview.event.RejectProtocolOnlineReviewCommentEvent;
import org.kuali.kra.meeting.CommitteeScheduleMinute;
import org.kuali.kra.rule.BusinessRuleInterface;
import org.kuali.kra.rule.event.KraDocumentEventBaseExtension;
import org.kuali.kra.rules.ResearchDocumentRuleBase;
import org.kuali.coeus.common.protocol.impl.committee.schedule.CommitteeScheduleMinuteBase;
import org.kuali.coeus.common.protocol.impl.onlinereview.ProtocolReviewAttachmentBase;
import org.kuali.coeus.common.protocol.impl.onlinereview.event.RouteProtocolOnlineReviewEvent;
import org.kuali.coeus.common.protocol.impl.onlinereview.event.SaveProtocolOnlineReviewEvent;
import org.kuali.coeus.common.protocol.impl.onlinereview.rules.RouteProtocolOnlineReviewRule;
import org.kuali.coeus.common.protocol.impl.onlinereview.rules.SaveProtocolOnlineReviewRule;
import org.kuali.coeus.sys.framework.util.DateUtils;
import org.kuali.rice.krad.service.KualiRuleService;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;

public class ProtocolOnlineReviewDocumentRule extends ResearchDocumentRuleBase implements AddOnlineReviewCommentRule
                                                                                         ,SaveProtocolOnlineReviewRule
                                                                                         ,BusinessRuleInterface 
                                                                                         ,RouteProtocolOnlineReviewRule
                                                                                         ,DisapproveOnlineReviewCommentRule
                                                                                         ,RejectOnlineReviewCommentRule
                                                                                         ,DeleteOnlineReviewRule
                                                                                         {

    private static final String ONLINE_REVIEW_COMMENTS_ERROR_PATH = "onlineReviewsActionHelper.reviewCommentsBeans[%s]";
    private static final String ONLINE_REVIEW_ATTACHMENTS_ERROR_PATH = "onlineReviewsActionHelper.reviewAttachmentsBeans[%s]";
    private static final String ONLINE_REVIEW_ERROR_PATH="onlineReviewsActionHelper.protocolOnlineReviewDocuments[%s].protocolOnlineReview";
    
    public boolean processAddProtocolOnlineReviewComment(ProtocolOnlineReview protocolOnlineReview, CommitteeScheduleMinute minute) {
        return false;
    }


    public boolean processAddProtocolOnlineReviewComment(AddProtocolOnlineReviewCommentEvent event) {
        
        boolean valid = true;
        CommitteeScheduleMinute minute = event.getCommitteeScheduleMinute();
        if (StringUtils.isEmpty(minute.getMinuteEntry()) && StringUtils.isEmpty(minute.getProtocolContingencyCode())) {
            valid = false;
            GlobalVariables.getMessageMap().clearErrorPath();
            GlobalVariables.getMessageMap().addToErrorPath(String.format( ONLINE_REVIEW_COMMENTS_ERROR_PATH, event.getOnlineReviewIndex()));
            GlobalVariables.getMessageMap().putError("newReviewComment.minuteEntry",  
                                                   KeyConstants.ERROR_ONLINE_REVIEW_COMMENT_REQUIRED);  
        }
        return valid;
    }

    public boolean processSaveProtocolOnlineReview(SaveProtocolOnlineReviewEvent event) {
        boolean valid = true;
        GlobalVariables.getMessageMap().clearErrorPath();
        GlobalVariables.getMessageMap().addToErrorPath(String.format(ONLINE_REVIEW_COMMENTS_ERROR_PATH, event.getOnlineReviewIndex()));
        
        ProtocolOnlineReview protocolOnlineReview = (ProtocolOnlineReview)event.getProtocolOnlineReviewDocument().getProtocolOnlineReview();
        
        int index = 0;
        
        for (CommitteeScheduleMinuteBase minute : event.getMinutes()) {
            if (StringUtils.isEmpty(minute.getMinuteEntry()) && StringUtils.isEmpty(minute.getProtocolContingencyCode())) {
                valid=false;
                GlobalVariables.getMessageMap().putError(String.format("reviewComments[%s].minuteEntry" ,index),  
                        KeyConstants.ERROR_ONLINE_REVIEW_COMMENT_REQUIRED);
            }
            index++;
        }
        
        GlobalVariables.getMessageMap().clearErrorPath();
        GlobalVariables.getMessageMap().addToErrorPath(String.format(ONLINE_REVIEW_ATTACHMENTS_ERROR_PATH, event.getOnlineReviewIndex()));
        index = 0;
        
        for (ProtocolReviewAttachmentBase reviewAttachment : event.getReviewAttachments()) {
            if (StringUtils.isEmpty(reviewAttachment.getDescription())) {
                valid=false;
                GlobalVariables.getMessageMap().putError(String.format("reviewAttachments[%s].description" ,index),  
                        KeyConstants.ERROR_ONLINE_REVIEW_ATTACHMENT_DESCRIPTION_REQUIRED);
            }
            index++;
        }
        
        GlobalVariables.getMessageMap().clearErrorPath();
        GlobalVariables.getMessageMap().addToErrorPath(String.format(ONLINE_REVIEW_ERROR_PATH, event.getOnlineReviewIndex()));
        
        if (StringUtils.isEmpty(protocolOnlineReview.getProtocolOnlineReviewStatusCode())) {
            GlobalVariables.getMessageMap().putError("protocolOnlineReviewStatusCode",  
                    KeyConstants.ERROR_ONLINE_REVIEW_STATUS_REQUIRED);
            valid = false;
        }
        
        if( protocolOnlineReview.getDateRequested() != null && protocolOnlineReview.getDateDue() != null ) {
            if ( (DateUtils.isSameDay(protocolOnlineReview.getDateDue(), protocolOnlineReview.getDateRequested())) || 
                 (protocolOnlineReview.getDateDue().after(protocolOnlineReview.getDateRequested())) ) {
                  //no-op,
            }
            else
            {   //dates are not the same or due date is before requested date
                valid=false;
                GlobalVariables.getMessageMap().putError("protocolOnlineReviewDueDate", "error.protocol.onlinereview.create.dueDateAfterRequestedDate", new String[0]);
            }
        }        
        
        
        return valid;
        
    }

    public boolean processRouteProtocolOnlineReview(RouteProtocolOnlineReviewEvent event) {
        
        boolean valid = true;
        KualiRuleService ruleService = KraServiceLocator.getService(KualiRuleService.class);
        valid &= ruleService.applyRules(new SaveProtocolOnlineReviewEvent(event.getProtocolOnlineReviewDocument(), (List)event.getMinutes(), event.getOnlineReviewIndex()));
        GlobalVariables.getMessageMap().clearErrorPath();
        GlobalVariables.getMessageMap().addToErrorPath(String.format(ONLINE_REVIEW_COMMENTS_ERROR_PATH, event.getOnlineReviewIndex()));
        return valid;
    }
    
    
    public boolean processDisapproveOnlineReviewComment(DisapproveProtocolOnlineReviewCommentEvent event) {
        boolean valid = true;
        if (StringUtils.isBlank(event.getReason()) ||
            event.getNoteText().length() > event.getMaxLength()) {
            valid = false;
        }
        return valid;
    }   

    public boolean processRejectOnlineReviewComment(RejectProtocolOnlineReviewCommentEvent event) {
        boolean valid = true;
        if (StringUtils.isBlank(event.getReason()) ||
            event.getReason().length() > event.getMaxLength()) {
            valid = false;
        }
        return valid;
    }    

    public boolean processDeleteOnlineReview(DeleteProtocolOnlineReviewEvent event) {
        boolean valid = true;
        if (StringUtils.isBlank(event.getReason()) ||
            event.getNoteText().length() > event.getMaxLength()) {
            valid = false;
        }
        return valid;        
    }

    public boolean processRules(KraDocumentEventBaseExtension event) {
        boolean retVal = false;
        retVal = event.getRule().processRules(event);
        return retVal;
    }


        
}
