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
package org.kuali.kra.iacuc.correspondence;

import org.kuali.coeus.common.protocol.impl.actions.correspondence.ProtocolActionsCorrespondenceBase;
import org.kuali.coeus.common.protocol.impl.actions.print.CorrespondenceXmlStreamBase;
import org.kuali.coeus.common.protocol.impl.actions.print.ProtocolPrintWatermarkBase;
import org.kuali.kra.iacuc.actions.correspondence.IacucProtocolActionTypeToCorrespondenceTemplateService;
import org.kuali.kra.iacuc.actions.print.IacucCorrespondenceXmlStream;
import org.kuali.kra.iacuc.actions.print.IacucProtocolPrintWatermark;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KraServiceLocator;
import org.kuali.kra.infrastructure.RoleConstants;

public class IacucProtocolActionsCorrespondence extends ProtocolActionsCorrespondenceBase {

    private static final long serialVersionUID = 241798237383300450L;
    private String protocolActionType;
    
    public IacucProtocolActionsCorrespondence(String protocolActionType) {
        this.protocolActionType = protocolActionType;
    }
    
    @Override
    public String getProtocolActionType() {
        return protocolActionType;
    }
    
    public void setProtocolActionType(String protocolActionType) {
        this.protocolActionType = protocolActionType;
    }

    @Override
    protected IacucProtocolActionTypeToCorrespondenceTemplateService getProtocolActionTypeToCorrespondenceTemplateService() {
        return KraServiceLocator.getService(IacucProtocolActionTypeToCorrespondenceTemplateService.class);
    }
    
    @Override
    protected ProtocolPrintWatermarkBase getNewProtocolPrintWatermarkInstanceHook() {
        return new IacucProtocolPrintWatermark();
    }

    @Override
    public CorrespondenceXmlStreamBase getCorrespondenceXmlStream() {
        return KraServiceLocator.getService(IacucCorrespondenceXmlStream.class);
    }

    @Override
    protected String getAdministratorType() {
        return RoleConstants.IACUC_ADMINISTRATOR;
    }

    @Override
    protected String getModuleNameSpace() {
        return Constants.MODULE_NAMESPACE_IACUC;
    }    

}
