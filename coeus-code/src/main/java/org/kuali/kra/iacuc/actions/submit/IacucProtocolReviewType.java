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
package org.kuali.kra.iacuc.actions.submit;

import org.kuali.coeus.common.protocol.impl.actions.submit.ProtocolReviewTypeBase;

/**
 * A Protocol Review Type refers to the type of review that an
 * IACUC Committee will perform
 */
@SuppressWarnings("serial")
public class IacucProtocolReviewType extends ProtocolReviewTypeBase {

    public static final String ADMINISTRATIVE_REVIEW = "1";
    
    public static final String DESIGNATED_MEMBER_REVIEW = "2";
    
    public static final String FULL_COMMITTEE_REVIEW = "3";
    
    public static final String FYI = "4";

    public static final String RESPONSE = "5";

    public static final String IACUC_REVIEW_NOT_REQUIRED = "6";

    /**
     * Constructs a ProtocolReviewType.
     */
    public IacucProtocolReviewType() {
    }

}
