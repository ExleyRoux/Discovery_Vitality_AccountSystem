package za.ac.nwu.ac.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransaction extends JpaRepository<AccountTransaction, Long> {
}
