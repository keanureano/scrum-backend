package scrumbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import scrumbackend.issue.Issue;
import scrumbackend.issue.IssueRepository;
import scrumbackend.task.Task;
import scrumbackend.task.TaskRepository;

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

  @Override
  public void run(String... args) throws Exception {
    Issue issue = Issue
      .builder()
      .issuesToday("Issue 1")
      .issuesYesterday("Issue 1")
      .build();
    issueRepository.save(issue);
    Issue issue2 = Issue
      .builder()
      .issuesToday("Issue 2")
      .issuesYesterday("Issue 2")
      .build();
    issueRepository.save(issue2);

    scrumbackend.task.Task task = scrumbackend.task.Task
      .builder()
      .tasksToday("Task Today 1")
      .tasksYesterday("Task Yesterday 1")
      .impediments("Impediment 1")
      .build();

    taskRepository.save(task);
    scrumbackend.task.Task task2 = Task
      .builder()
      .tasksToday("Task Today 2")
      .tasksYesterday("Task Yesterday 2")
      .impediments("Impediment 2")
      .build();
    taskRepository.save(task2);

    scrumbackend.task.Task task3 = Task
      .builder()
      .tasksToday("Task Today 2")
      .tasksYesterday("Task Yesterday 2")
      .impediments("Impediment 2")
      .isResolved(true)
      .build();
    taskRepository.save(task3);
  }
}
