package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDTO;
import za.ac.nwu.ac.logic.flow.FetchTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchTransactionFlowImpl implements FetchTransactionFlow {
    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public FetchTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public List<AccountTransactionDTO> getAllTransactions() {
        return null;
    }
}
