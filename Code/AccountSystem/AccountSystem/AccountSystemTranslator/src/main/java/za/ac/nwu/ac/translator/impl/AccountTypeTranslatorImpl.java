package za.ac.nwu.ac.translator.impl;

import antlr.ASTNULLType;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repository.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.swing.tree.ExpandVetoException;
import java.util.ArrayList;
import java.util.List;

public class AccountTypeTranslatorImpl implements AccountTypeTranslator {
    private AccountTypeRepository accountTypeRepository;

    public AccountTypeRepository getAccountTypeRepository() {
        return accountTypeRepository;
    }

    public void setAccountTypeRepository(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for(AccountType accountType : accountTypeRepository.findAll()){
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {
        try{
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        } catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
