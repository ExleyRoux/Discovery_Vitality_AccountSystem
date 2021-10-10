package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
@ComponentScan(value = "za.ac.nwu.ac.translator")
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {
    @Autowired
    private final AccountTypeTranslator accountTypeTranslator;

    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    public List<AccountTypeDTO> getAllAccountTypes(){
        return accountTypeTranslator.getAllAccountTypes();
    }
}
