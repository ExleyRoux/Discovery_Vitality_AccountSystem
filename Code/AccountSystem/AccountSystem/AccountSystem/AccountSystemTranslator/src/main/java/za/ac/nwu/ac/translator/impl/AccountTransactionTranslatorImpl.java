package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDTO;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repository.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.repository.persistence.AccountTypeRepository;
import za.ac.nwu.ac.repository.persistence.MemberRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {
    private final AccountTransactionRepository accountTransactionRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository, AccountTypeRepository accountTypeRepository, MemberRepository memberRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
        this.accountTypeRepository = accountTypeRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public AccountTransactionDTO create(AccountTransactionDTO accountTransactionDTO) {
        try {
            Member member = memberRepository.getOne(accountTransactionDTO.getMemberId());
            AccountType accountType = accountTypeRepository.getOne(accountTransactionDTO.getTransactionAccountTypeId());
            return new AccountTransactionDTO(accountTransactionRepository.save(new AccountTransaction(accountType, member, accountTransactionDTO.getTransactionAmount(), LocalDate.now())));
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
}
