package vulnerablewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vulnerablewebapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}