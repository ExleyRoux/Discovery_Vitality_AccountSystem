package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repository.persistence.AccountTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslationImpl implements AccountTypeTranslator {
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    public AccountTypeTranslationImpl() {
    }

    public AccountTypeTranslationImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public AccountTypeRepository getAccountTypeRepository() {
        return accountTypeRepository;
    }
    public void setAccountTypeRepository(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDTO> getAllAccountTypes(){
        List<AccountTypeDTO> accountTypeDTOs = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDTOs.add(new AccountTypeDTO(accountType));
            }
            //accountTypeDTOs.add(new AccountTypeDTO(new AccountType("TEST", "Test", LocalDate.now())));
        }catch (Exception e){
//            System.out.println(e.getCause().toString());
            throw new RuntimeException("Unable to read from Database",e);
        }
        return accountTypeDTOs;
    }

//    @Override
//    public AccountTypeDTO getAccountTypeByMnemonicNativeQuery(String mnemonic) {
//        try {
//            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonicNativeQuery(mnemonic);
//            return new AccountTypeDTO(accountType);
//        }catch (Exception e){
//            throw new RuntimeException("Unable to read from the DB",e);
//        }
//
//    }

//    @Override
//    public AccountTypeDTO getAccountTypeByMnemonic(String mnemonic) {
//        try {
//            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
//            return new AccountTypeDTO(accountType);
//        }catch (Exception e){
//            throw new RuntimeException("Unable to read from the DB",e);
//        }
//    }

//    @Override
//    public AccountTypeDTO getAccountTypeDTOByMnemonic(String mnemonic) {
//        try {
//            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
//            return new AccountTypeDTO(accountType);
//        }catch (Exception e){
//            throw new RuntimeException("Unable to read from the DB",e);
//        }
//    }

    @Override
    public AccountTypeDTO create(AccountTypeDTO accountTypeDTO){
        try {
            AccountType accountType = accountTypeRepository.save(accountTypeDTO.getAccountType());
            return new AccountTypeDTO(accountType);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
