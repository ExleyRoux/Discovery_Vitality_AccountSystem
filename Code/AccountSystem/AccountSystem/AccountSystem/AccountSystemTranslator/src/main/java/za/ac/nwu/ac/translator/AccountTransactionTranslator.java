package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDTO;
import za.ac.nwu.ac.repository.persistence.AccountTransactionRepository;

import java.util.List;

public interface AccountTransactionTranslator {
    AccountTransactionDTO create(AccountTransactionDTO accountTransactionDTO);
    List<AccountTransactionDTO> getAllAccountTransactions();
    AccountTransactionRepository getAccountTransactionRepository();
}
