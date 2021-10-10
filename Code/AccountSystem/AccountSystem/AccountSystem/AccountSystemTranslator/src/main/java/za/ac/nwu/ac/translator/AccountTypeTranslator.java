package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTypeDTO;

import java.util.List;

public interface AccountTypeTranslator {
    AccountTypeDTO create(AccountTypeDTO accountType);
    List<AccountTypeDTO> getAllAccountTypes();
}
