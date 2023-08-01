package scrumbackend;


import scrumbackend.employee.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import scrumbackend.employee.Employee;
import scrumbackend.employee.EmployeeRepository;
import scrumbackend.team.Team;
import scrumbackend.team.TeamRepository;

@SpringBootApplication
public class ScrumBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrumBackendApplication.class, args);
	}

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	TeamRepository teamRepository;

	@Override
	public void run(String... args) throws Exception {

		Team team = Team.builder().name("Team 1").build();
		teamRepository.save(team);

		Team team2 = Team.builder().name("Team 2").build();
		teamRepository.save(team2);

		Employee employee = Employee.builder()
				.name("Franz")
				.email("420@gmail.com")
				.password("password")
				.role(Roles.ADMIN)
				.team(team)
				.build();
		employeeRepository.save(employee);

		Employee employee2 = Employee.builder()
				.name("Lariba")
				.email("islife@gmail.com")
				.password("password")
				.role(Roles.USER)
				.team(team2)
				.build();
		employeeRepository.save(employee2);
	}
}
