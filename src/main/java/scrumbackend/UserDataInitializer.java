package scrumbackend;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import scrumbackend.scrum.Scrum;
import scrumbackend.scrum.ScrumRepository;
import scrumbackend.task.Task;
import scrumbackend.task.TaskRepository;
import scrumbackend.team.Team;
import scrumbackend.team.TeamRepository;
import scrumbackend.user.Role;
import scrumbackend.user.User;
import scrumbackend.user.UserRepository;

@Component
@RequiredArgsConstructor
public class UserDataInitializer implements CommandLineRunner {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final TeamRepository teamRepository;
  private final TaskRepository taskRepository;
  private final ScrumRepository scrumRepository;

  @Override
  public void run(String... args) {
    // Create a team and assign users
    Team team = createTeam("Test");

    // Create a Scrum
    Scrum scrum = createScrum("Issues Today");

    // Create users
    User user = createUser(
      "user@example.com",
      "User Name",
      "userpassword",
      Role.USER,
      team
    );

    User admin = createUser(
      "admin@example.com",
      "Admin Name",
      "adminpassword",
      Role.ADMIN,
      team
    );

    createUser(
      "inactive@example.com",
      "Inactive Name",
      "inactivepassword",
      Role.INACTIVE,
      team
    );

    // Create Tasks for User and Admin
    createTask(
      "User's task details",
      "User's yesterday details",
      "User's impediments",
      scrum,
      user
    );

    createTask(
      "Admin's task details",
      "Admin's yesterday details",
      "Admin's impediments",
      scrum,
      admin
    );
  }

  private User createUser(
    String email,
    String name,
    String password,
    Role role,
    Team team
  ) {
    return userRepository.save(
      User
        .builder()
        .email(email)
        .name(name)
        .password(passwordEncoder.encode(password))
        .role(role)
        .team(team)
        .build()
    );
  }

  private Team createTeam(String teamName) {
    return teamRepository.save(Team.builder().name(teamName).build());
  }

  private Task createTask(
    String tasksYesterday,
    String tasksToday,
    String impediments,
    Scrum scrum,
    User user
  ) {
    return taskRepository.save(
      Task
        .builder()
        .tasksYesterday(tasksYesterday)
        .tasksToday(tasksToday)
        .impediments(impediments)
        .scrum(scrum)
        .user(user)
        .build()
    );
  }

  private Scrum createScrum(String issues) {
    return scrumRepository.save(Scrum.builder().issues(issues).build());
  }
}
