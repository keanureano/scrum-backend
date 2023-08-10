package scrumbackend;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import scrumbackend.user.Role;
import scrumbackend.user.User;
import scrumbackend.user.UserRepository;

@Component
@RequiredArgsConstructor
public class UserDataInitializer implements CommandLineRunner {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) {
    createUser("user@example.com", "userpassword", Role.USER);

    createUser("admin@example.com", "adminpassword", Role.ADMIN);

    createUser("inactive@example.com", "inactivepassword", Role.INACTIVE);
  }

  private void createUser(String email, String password, Role role) {
    Optional<User> existingUser = userRepository.findByEmail(email);

    if (existingUser.isPresent()) {
      return;
    }

    User user = User
      .builder()
      .email(email)
      .password(passwordEncoder.encode(password))
      .role(role)
      .build();
    userRepository.save(user);
  }
}
