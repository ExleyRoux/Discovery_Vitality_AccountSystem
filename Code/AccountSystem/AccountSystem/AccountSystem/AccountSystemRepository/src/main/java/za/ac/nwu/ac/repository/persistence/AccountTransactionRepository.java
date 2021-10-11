package za.ac.nwu.ac.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.Member;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Integer> {

//    @Query(value =
//                    "SELECT " +
//                    "at " +
//                    "FROM " +
//                    "account_transactions " +
//                    "at " +
//                    "WHERE at.member = :member ") //you can "join" the tables to be able to reference them e.g. at.accountTransactions.memberId
//    List<AccountTransaction> getAccountTransactionsByMemberId(Member member);
}
