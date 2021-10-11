package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDTO;
import za.ac.nwu.ac.domain.dto.AccountTypeDTO;

public interface CreateTransactionFlow {
    AccountTransactionDTO create(AccountTransactionDTO accountTypeDTO);
}
