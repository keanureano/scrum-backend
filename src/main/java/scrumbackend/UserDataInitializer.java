package scrumbackend;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import scrumbackend.team.Team;
import scrumbackend.team.TeamRepository;
import scrumbackend.user.Role;
import scrumbackend.user.User;
import scrumbackend.user.UserRepository;

@Component
@RequiredArgsConstructor
public class UserDataInitializer implements CommandLineRunner {

  private final UserRepository userRepository;
  private final TeamRepository teamRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) {
    Team team = createTeamIfNotExist("Example Team");

    createUserIfNotExist(
      "user@example.com",
      "User Name",
      "userpassword",
      Role.USER,
      team
    );

    createUserIfNotExist(
      "admin@example.com",
      "Admin Name",
      "adminpassword",
      Role.ADMIN,
      team
    );

    createUserIfNotExist(
      "inactive@example.com",
      "Inactive Name",
      "inactivepassword",
      Role.INACTIVE,
      team
    );
  }

  private Team createTeamIfNotExist(String teamName) {
    return teamRepository
      .findByName(teamName)
      .orElseGet(() ->
        teamRepository.save(Team.builder().name(teamName).build())
      );
  }

  private User createUserIfNotExist(
    String email,
    String name,
    String password,
    Role role,
    Team team
  ) {
    return userRepository
      .findByEmail(email)
      .orElseGet(() ->
        userRepository.save(
          User
            .builder()
            .email(email)
            .name(name)
            .password(passwordEncoder.encode(password))
            .role(role)
            .team(team)
            .build()
        )
      );
  }
}
