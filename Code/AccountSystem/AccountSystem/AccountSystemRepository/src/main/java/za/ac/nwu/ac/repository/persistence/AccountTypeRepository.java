package za.ac.nwu.ac.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountType;


//set up the repository extends jpa - very nice features, set up with table class and pk id type
@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {

}
