package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDTO;

import java.util.List;

public interface FetchTransactionFlow {
    List<AccountTransactionDTO> getAllTransactions();
}
