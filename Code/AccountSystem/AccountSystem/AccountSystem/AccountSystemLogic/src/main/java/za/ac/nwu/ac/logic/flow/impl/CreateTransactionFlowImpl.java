package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDTO;
import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.logic.flow.CreateTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("createTransactionFlowName")
public class CreateTransactionFlowImpl implements CreateTransactionFlow {
    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public CreateTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDTO create(AccountTransactionDTO accountTypeDTO) {
        return null;
    }
}
