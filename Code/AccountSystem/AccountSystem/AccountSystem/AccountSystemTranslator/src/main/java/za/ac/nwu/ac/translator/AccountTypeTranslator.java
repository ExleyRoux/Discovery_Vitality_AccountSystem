package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.List;

public interface AccountTypeTranslator {

    AccountTypeDTO create(AccountTypeDTO accountType);
    List<AccountTypeDTO> getAllAccountTypes();

//    AccountTypeDTO getAccountTypeByMnemonicNativeQuery(String mnemonic);
//    AccountTypeDTO getAccountTypeByMnemonic(String mnemonic);
//    AccountTypeDTO getAccountTypeDTOByMnemonic(String mnemonic);
}
