package za.ac.nwu.ac.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDTO;
import za.ac.nwu.ac.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {

    //native queries are NOT recommended use String mnemonic in query
//    @Query(value =
//                    "SELECT " +
//                    "ID_ACCOUNT_TYPES " +
//                    "NAME " +
//                    "CREATION_DATE " +
//                    "MNEMONIC " +
//                    "FROM " +
//                    "account_system.account_types " +
//                    "WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
//    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);


    //use this one from single tables, whatever that means
//    @Query(value =
//                    "SELECT " +
//                    "   at " +
//                    "FROM " +
//                    "   AccountType at" +
//                    "WHERE at.mnemonic = :mnemonic ") //you can "join" the tables to be able to reference them e.g. at.accountTransactions.memberId
//    AccountType getAccountTypeByMnemonic(String mnemonic);


    //use this one for multiple tables at a time ig - this one returns the DTO
    //put the returned cols into the constructor of the AccountTypeDTO like this
    //dont do this too often apparently
//    @Query(value =
//                    "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDTO( " +
//                    "   at.mnemonic, " +
//                    "   at.accountTypeName, " +
//                    "   at.creationDate )" +
//                    "FROM " +
//                    "   AccountType at" +
//                    "WHERE at.mnemonic = :mnemonic ")
//    AccountTypeDTO getAccountTypeDTOByMnemonic(String mnemonic);
}
