package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.domain.dto.MemberDTO;

public interface CreateAccountTypeFlow {
    AccountTypeDTO create(AccountTypeDTO accountType);
}
