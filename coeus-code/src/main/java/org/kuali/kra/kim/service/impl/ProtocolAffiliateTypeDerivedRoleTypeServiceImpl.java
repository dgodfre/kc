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
package org.kuali.kra.kim.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.kuali.coeus.common.protocol.impl.personnel.ProtocolPersonBase;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.core.api.membership.MemberType;
import org.kuali.rice.kim.api.role.RoleMembership;
import org.kuali.rice.kns.kim.role.DerivedRoleTypeServiceBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings("deprecation")
public class ProtocolAffiliateTypeDerivedRoleTypeServiceImpl extends DerivedRoleTypeServiceBase {
    
    protected List<String> requiredAttributes = new ArrayList<String>();
    {
        requiredAttributes.add(KcKimAttributes.PROTOCOL);
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public List<RoleMembership> getRoleMembersFromDerivedRole(String namespaceCode, String roleName,
            Map<String,String> qualification) {
        validateRequiredAttributesAgainstReceived(qualification);

        List<RoleMembership> members = new ArrayList<RoleMembership>();

        String protocolNumber = qualification.get(KcKimAttributes.PROTOCOL);       
        Protocol protocol = getProtocol(protocolNumber);
        
        if (protocol != null && CollectionUtils.isNotEmpty(protocol.getProtocolPersons())) {
            for (ProtocolPersonBase person : protocol.getProtocolPersons()) {
                if(person.getAffiliationType() != null) {
                    if (StringUtils.equals(person.getAffiliationType().getDescription(), roleName) &&
                        StringUtils.isNotBlank(person.getPerson().getPersonId())) {
                        members.add(RoleMembership.Builder.create(null, null, person.getPerson().getPersonId(), MemberType.PRINCIPAL, null).build());
        
                    }
                }
            }
        }
        
        return members;
    }
    
    @Override
    public boolean hasDerivedRole(String principalId, List<String> groupIds, String namespaceCode, String roleName,
            Map<String,String> qualification) {
        validateRequiredAttributesAgainstReceived(qualification);
        
        String protocolNumber = qualification.get(KcKimAttributes.PROTOCOL);
        
        Protocol protocol = getProtocol(protocolNumber);

        if (protocol != null && CollectionUtils.isNotEmpty(protocol.getProtocolPersons())) {
            for (ProtocolPersonBase person : protocol.getProtocolPersons()) {
                //Find protocol person that matches the principal id
                if (StringUtils.equals(principalId, person.getPersonId())) {
                    if(person.getAffiliationType() != null) {
                        if (StringUtils.equals(roleName, person.getAffiliationType().getDescription())) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    private Protocol getProtocol(String protocolNumber) {
        Map<String,Object> keymap = new HashMap<String,Object>();
        keymap.put("protocolNumber", protocolNumber);
        return (Protocol) getBusinessObjectService().findByPrimaryKey(Protocol.class, keymap);
    }
    
    /*
     * Should override if derivedRoles should not to be cached.
     */
    @Override
    public boolean dynamicRoleMembership(String namespaceCode, String roleName) {
        super.dynamicRoleMembership(namespaceCode, roleName);
        return true;
    }
}
