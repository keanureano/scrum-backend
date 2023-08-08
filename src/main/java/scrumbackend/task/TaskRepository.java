package scrumbackend.task;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
  Optional<Task> findById(Long Id);
  List<Task> findByCreatedAtBetween(Instant from, Instant to);
}
