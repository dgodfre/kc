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
package org.kuali.coeus.common.protocol.impl.actions;

import org.kuali.coeus.common.protocol.impl.ProtocolBase;
import org.kuali.coeus.common.protocol.impl.ProtocolFormBase;
import org.kuali.coeus.common.protocol.impl.correspondence.ProtocolCorrespondence;
import org.kuali.coeus.common.protocol.impl.notification.ProtocolNotificationRequestBeanBase;

public interface ProtocolActionRequestService {

    public void createProtocol(ProtocolFormBase protocolForm) throws Exception;
    
    public void rejectedInRouting(ProtocolBase protocol) throws Exception;

    public void recalledInRouting(ProtocolBase protocol) throws Exception;

    public boolean checkToSendNotification(ProtocolFormBase protocolForm, ProtocolNotificationRequestBeanBase notificationRequestBean, String promptAfterNotification);
    
    /**
     * This method checks the document state to see if something has changed between the time the user
     * loaded the document to when they clicked on an action.
     * @param protocolForm
     * @return
     */
    public boolean hasDocumentStateChanged(ProtocolFormBase protocolForm);
    
    public ProtocolCorrespondence getProtocolCorrespondence (ProtocolFormBase protocolForm, String forwardName, ProtocolNotificationRequestBeanBase notificationRequestBean, boolean holdingPage);
    
}
