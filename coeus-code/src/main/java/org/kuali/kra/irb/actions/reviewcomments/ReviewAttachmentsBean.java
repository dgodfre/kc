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
package org.kuali.kra.irb.actions.reviewcomments;

import org.kuali.coeus.common.protocol.impl.actions.reviewcomments.ReviewAttachmentsBeanBase;
import org.kuali.kra.irb.onlinereview.ProtocolReviewAttachment;

/**
 * 
 * This class for UI set up review attachments
 */
public class ReviewAttachmentsBean extends ReviewAttachmentsBeanBase<ProtocolReviewAttachment> {

    private static final long serialVersionUID = -5330578993055642005L;

    public ReviewAttachmentsBean(String errorPropertyKey) {
        super(errorPropertyKey);
    }

    @Override
    protected ProtocolReviewAttachment getNewProtocolReviewAttachmentInstanceHook() {
        return new ProtocolReviewAttachment();
    }
}
