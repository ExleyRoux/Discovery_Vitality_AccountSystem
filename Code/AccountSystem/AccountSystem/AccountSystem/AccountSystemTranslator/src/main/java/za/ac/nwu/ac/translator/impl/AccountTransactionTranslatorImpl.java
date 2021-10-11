package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDTO;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repository.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.repository.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {
    private AccountTransactionRepository accountTransactionRepository;

    public AccountTransactionTranslatorImpl() {
    }

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public AccountTransactionDTO create(AccountTransactionDTO accountTransactionDTO) {
        try {
            AccountTransaction accountTransaction = accountTransactionRepository.save(accountTransactionDTO.getAccountTransaction());
            return new AccountTransactionDTO(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public List<AccountTransactionDTO> getAllAccountTransactions() {
        List<AccountTransactionDTO> accountTransactionDTOS = new ArrayList<>();
        try {
            for (AccountTransaction accountTransaction : accountTransactionRepository.findAll()){
                accountTransactionDTOS.add(new AccountTransactionDTO(accountTransaction));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from Database", e);
        }
        return accountTransactionDTOS;
    }

    @Override
    public AccountTransactionRepository getAccountTransactionRepository() {
        return accountTransactionRepository;
    }
    public void setAccountTransactionRepository(AccountTypeRepository accountTypeRepository){
        this.accountTransactionRepository = accountTransactionRepository;
    }
}
