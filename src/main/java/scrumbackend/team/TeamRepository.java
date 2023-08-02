package scrumbackend.team;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> { 
        Optional<Team> findById(Long id);
        List<Team> findByNameContainsIgnoreCase(String name);
}
