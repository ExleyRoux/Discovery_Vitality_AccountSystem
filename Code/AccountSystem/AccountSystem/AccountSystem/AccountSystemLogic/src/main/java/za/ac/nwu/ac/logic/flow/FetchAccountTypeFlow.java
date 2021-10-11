package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.domain.dto.MemberDTO;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDTO> getAllAccountTypes();


//    AccountTypeDTO getAccountTypeByMnemonic(String mnemonic);
}
