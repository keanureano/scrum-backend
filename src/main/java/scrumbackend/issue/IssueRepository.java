package scrumbackend.issue;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
  Optional<Issue> findById(Long id);
  List<Issue> findByCreatedAtBetween(Date from, Date to);
  
}