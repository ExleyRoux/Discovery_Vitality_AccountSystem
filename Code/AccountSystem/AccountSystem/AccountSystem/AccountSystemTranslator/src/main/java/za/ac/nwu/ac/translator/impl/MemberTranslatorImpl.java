package za.ac.nwu.ac.translator.impl;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountBalanceDTO;
import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.domain.dto.MemberDTO;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repository.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.repository.persistence.MemberRepository;
import za.ac.nwu.ac.translator.MemberTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTranslatorImpl implements MemberTranslator {
    @Autowired
    private MemberRepository memberRepository;
    private AccountTransactionRepository transactionRepository;

    public MemberTranslatorImpl(MemberRepository memberRepo) {
        this.memberRepository = memberRepo;
    }
    public MemberRepository getMemberRepository(){return memberRepository;}
    public void setMemberRepository(MemberRepository member){this.memberRepository = member;}

    @Override
    public MemberDTO create(MemberDTO memberDTO) {
        try{
            Member member = memberRepository.save(memberDTO.getMember());
            return new MemberDTO((member));
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public List<MemberDTO> getAllMembers(){
        List<MemberDTO> memberDTOS = new ArrayList<>();
        try {
            for(Member member : memberRepository.findAll()){
                memberDTOS.add(new MemberDTO(member));
            }
        }catch  (Exception e){
            throw new RuntimeException("Unable to read from Database", e);
        }
        return memberDTOS;
    }

//    @Override
//    public List<AccountBalanceDTO> getBalance(Integer memberId) {
//        try {
//            List<AccountBalanceDTO> accountBalance = new ArrayList<>();
//
//            Member member = memberRepository.getOne(memberId);
//            List<AccountTransaction> accountTransactions = transactionRepository.getAccountTransactionsByMemberId(member);
//
//            for (AccountTransaction transaction : accountTransactions){
//                boolean hasBalance = false;
//                for(int i = 0; i < accountBalance.size(); i++){
//                    AccountBalanceDTO tempBalance = accountBalance.get(i);
//                    if(tempBalance.getAccountId() == transaction.getAccountType().getId()){
//                        hasBalance = true;
//                        tempBalance.setBalance(
//                                tempBalance.getBalance() + transaction.getAmount()
//                        );
//                        accountBalance.set(i, tempBalance);
//                    }
//                }
//                if(!hasBalance){
//                    accountBalance.add(
//                            new AccountBalanceDTO(transaction.getAmount(),
//                                    transaction.getAccountType().getId())
//                    );
//                }
//            }
//            return accountBalance;
//        }catch (Exception e)
//        {
//            throw new RuntimeException("Could not read from DB");
//        }
//    }
}
