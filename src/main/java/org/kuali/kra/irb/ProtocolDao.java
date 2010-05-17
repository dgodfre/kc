/*
 * Copyright 2005-2010 The Kuali Foundation
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
package org.kuali.kra.irb;

import java.util.List;
import java.util.Map;

import org.kuali.kra.irb.noteattachment.ProtocolAttachmentBase;
import org.kuali.kra.irb.noteattachment.ProtocolAttachmentProtocol;
import org.kuali.kra.irb.noteattachment.TypedAttachment;


/**
 * 
 * This class is used to run ojb query directly.
 */
public interface ProtocolDao {
    
    /**
     * 
     * This method get protocols lookup search results.
     * @param fieldValues
     * @return
     */
    List<Protocol> getProtocols(Map<String,String> fieldValues);
    
    /**
     * 
     * This method Check if there are any pending amendmends/renewals for this protocols.
     * @param protocolNumber
     * @return
     */
    boolean getProtocolSubmissionCountFromProtocol(String protocolNumber);
    
    /**
     * Gets all the attachment versions based on the passed in attachment.  This will include the pass-in attachment. 
     * @param attachment the attachment to base the query off of
     * @param type a class token used for retrieving the attachments
     * @return the list of attachments, empty list if none to return or the attachment is invalid for a lookup
     */
    <T extends ProtocolAttachmentBase & TypedAttachment> List<T> retrieveAttachmentVersions(T attachment, Class<T> type);
}
