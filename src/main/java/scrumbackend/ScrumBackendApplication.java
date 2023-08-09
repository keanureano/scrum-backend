package scrumbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import scrumbackend.user.Roles;
import scrumbackend.user.User;
import scrumbackend.user.UserRepository;
import scrumbackend.issue.Issue;
import scrumbackend.issue.IssueRepository;
import scrumbackend.task.Task;
import scrumbackend.task.TaskRepository;
import scrumbackend.team.Team;
import scrumbackend.team.TeamRepository;

@SpringBootApplication
@EnableJpaAuditing
public class ScrumBackendApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ScrumBackendApplication.class, args);
  }

  @Autowired
  IssueRepository issueRepository;

  @Autowired
  TaskRepository taskRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  TeamRepository teamRepository;

  @Override
  public void run(String... args) throws Exception {
    Issue issue = Issue
      .builder()
      .issuesToday("Issue 1")
      .issuesYesterday("Issue 1")
      .isResolved(true)
      .build();
    issueRepository.save(issue);

    Issue issue2 = Issue
      .builder()
      .issuesToday("Issue 2")
      .issuesYesterday("Issue 2")
      .build();
    issueRepository.save(issue2);

    Team team = Team.builder().name("Team 1").build();
    teamRepository.save(team);

    Team team2 = Team.builder().name("Team 2").build();
    teamRepository.save(team2);

    User user = User
      .builder()
      .name("Franz")
      .email("420@gmail.com")
      .password("password")
      .role(Roles.ADMIN)
      .team(team)
      .build();
    userRepository.save(user);

    User user2 = User
      .builder()
      .name("Lariba")
      .email("islife@gmail.com")
      .password("password")
      .role(Roles.USER)
      .team(team2)
      .build();
    userRepository.save(user2);

    scrumbackend.task.Task task = scrumbackend.task.Task
      .builder()
      .tasksToday("Task Today 1")
      .tasksYesterday("Task Yesterday 1")
      .impediments("Impediment 1")
      .user(user)
      .build();
    taskRepository.save(task);

    scrumbackend.task.Task task2 = Task
      .builder()
      .tasksToday("Task Today 2")
      .tasksYesterday("Task Yesterday 2")
      .impediments("Impediment 2")
      .user(user2)
      .build();
    taskRepository.save(task2);

    scrumbackend.task.Task task3 = Task
      .builder()
      .tasksToday("Task Today 2")
      .tasksYesterday("Task Yesterday 2")
      .impediments("Impediment 2")
      .user(user2)
      .isResolved(true)
      .build();
    taskRepository.save(task3);
  }
}
