package scrumbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import scrumbackend.issues.Issue;
import scrumbackend.issues.IssueRepo;

@SpringBootApplication
@EnableJpaAuditing
public class ScrumBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrumBackendApplication.class, args);
	}

	@Autowired
	IssueRepo issueRepo;

	@Override
	public void run(String... args) throws Exception {

		Issue issue = Issue.builder().issuesToday("Issue 1").issuesYesterday("Issue 1").build();
		issueRepo.save(issue);
		Issue issue2 = Issue.builder().issuesToday("Issue 2").issuesYesterday("Issue 2").build();
		issueRepo.save(issue2);

	}

}
