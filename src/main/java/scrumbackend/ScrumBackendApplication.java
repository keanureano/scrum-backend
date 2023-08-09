package scrumbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ScrumBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(ScrumBackendApplication.class, args);
  }
}
