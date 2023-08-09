package scrumbackend.user;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findById(Long id);
  List<User> findByNameContainsIgnoreCase(String name);
  List<User> findByEmailContainsIgnoreCase(String email);
}
