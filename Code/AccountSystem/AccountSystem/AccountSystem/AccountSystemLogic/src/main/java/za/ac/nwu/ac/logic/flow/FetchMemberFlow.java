package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountBalanceDTO;
import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.domain.dto.MemberDTO;

import java.util.List;

public interface FetchMemberFlow {
    List<MemberDTO> getAllMembers();
//    List<AccountBalanceDTO> getBalance(Integer memberId);
}
