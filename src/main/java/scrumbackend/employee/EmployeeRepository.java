package scrumbackend.employee;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  Optional<Employee> findById(Long id);
  List<Employee> findByNameContainsIgnoreCase(String name);
  List<Employee> findByEmailContainsIgnoreCase(String email);
}
