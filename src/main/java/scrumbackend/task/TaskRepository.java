package scrumbackend.task;

import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByCreatedAtBetween(Instant from, Instant to);
}
