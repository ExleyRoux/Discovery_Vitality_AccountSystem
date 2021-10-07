package za.ac.nwu.ac.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
