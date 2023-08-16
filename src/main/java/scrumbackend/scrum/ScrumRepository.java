package scrumbackend.scrum;

import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrumRepository extends JpaRepository<Scrum, Long> {
  List<Scrum> findByCreatedAtBetween(Instant from, Instant to);
}
