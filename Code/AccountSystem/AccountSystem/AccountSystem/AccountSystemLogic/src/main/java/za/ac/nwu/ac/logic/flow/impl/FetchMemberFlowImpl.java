package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountBalanceDTO;
import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.domain.dto.MemberDTO;
import za.ac.nwu.ac.logic.flow.FetchMemberFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchMemberFlowImpl implements FetchMemberFlow {

    private final MemberTranslator memberTranslator;

    @Autowired
    public FetchMemberFlowImpl(MemberTranslator memberTranslator){
        this.memberTranslator = memberTranslator;
    }

    public List<MemberDTO> getAllMembers(){
        return memberTranslator.getAllMembers();
    }

//    @Override
//    public List<AccountBalanceDTO> getBalance(Integer memberId) {
//        return memberTranslator.getBalance(memberId);
//    }
}
