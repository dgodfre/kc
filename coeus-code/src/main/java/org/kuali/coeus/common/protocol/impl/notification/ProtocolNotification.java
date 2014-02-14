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
package org.kuali.coeus.common.protocol.impl.notification;

import org.kuali.coeus.common.protocol.impl.ProtocolBase;
import org.kuali.kra.bo.KraPersistableBusinessObjectBase;
import org.kuali.kra.common.notification.bo.KcNotification;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.rice.krad.service.BusinessObjectService;

/**
 * Defines a document-specific instance of a Notification Type.
 */
public class ProtocolNotification extends KcNotification {

    private static final long serialVersionUID = -8718347978876523074L;

    public void persistOwningObject(KraPersistableBusinessObjectBase object) {
        ProtocolBase protocol = (ProtocolBase)object;
        protocol.getLastProtocolAction().addNotification(this);
        KraServiceLocator.getService(BusinessObjectService.class).save(protocol);
        KraServiceLocator.getService(BusinessObjectService.class).save(this);
    }

    public static void copy(KcNotification source, KcNotification target) {
        target.setNotificationId(source.getNotificationId());
        target.setNotificationTypeId(source.getNotificationTypeId());
        target.setDocumentNumber(source.getDocumentNumber());
        target.setRecipients(source.getRecipients());
        target.setSubject(source.getSubject());
        target.setMessage(source.getMessage());
        target.setNotificationType(source.getNotificationType());
        target.setNotificationTypeId(source.getNotificationTypeId());
    }

}
