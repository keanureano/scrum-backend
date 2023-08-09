package scrumbackend.issue;

import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
  List<Issue> findByCreatedAtBetween(Instant from, Instant to);
}
