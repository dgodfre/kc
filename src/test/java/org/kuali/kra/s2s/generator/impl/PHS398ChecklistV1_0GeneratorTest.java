/*
 * Copyright 2005-2010 The Kuali Foundation.
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
package org.kuali.kra.s2s.generator.impl;

import java.util.ArrayList;
import java.util.List;

import org.kuali.kra.proposaldevelopment.bo.ProposalYnq;
import org.kuali.kra.proposaldevelopment.document.ProposalDevelopmentDocument;
import org.kuali.kra.s2s.generator.S2STestBase;

/**
 * This class tests the PHS398ChecklistV1_0 generator
 */
@org.junit.Ignore("This test is not meant to be run against the 2.0 release")
public class PHS398ChecklistV1_0GeneratorTest extends S2STestBase<PHS398ChecklistV1_0Generator> {

    @Override
    protected Class<PHS398ChecklistV1_0Generator> getFormGeneratorClass() {
        return PHS398ChecklistV1_0Generator.class;
    }

    @Override
    protected void prepareData(ProposalDevelopmentDocument document) throws Exception {
        document.getDevelopmentProposal().setProposalTypeCode("2");
        ProposalYnq proposalYnq = new ProposalYnq();
        proposalYnq.setAnswer("Y");
        proposalYnq.setQuestionId("22");
        proposalYnq.setExplanation("David,Blain");
        List<ProposalYnq> ynqList = new ArrayList<ProposalYnq>();
        ynqList.add(proposalYnq);
        document.getDevelopmentProposal().setProposalYnqs(ynqList);
    }
}
