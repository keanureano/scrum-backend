package scrumbackend.team;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
  Optional<Team> findById(Long id);
  List<Team> findByNameContainsIgnoreCase(String name);
}
