package scrumbackend.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import scrumbackend.task.Task;
import scrumbackend.team.Team;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User implements UserDetails {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long Id;

  @Column(unique = true)
  private String email;

  @JsonIgnore
  private String password;

  private String name;

  @Enumerated(EnumType.STRING)
  private Role role;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;

  @OneToMany(mappedBy = "user")
  private List<Task> tasks;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    switch (role) {
      case ADMIN:
        authorities.add(new SimpleGrantedAuthority(Role.ADMIN.name()));
        authorities.add(new SimpleGrantedAuthority(Role.USER.name()));
        break;
      case USER:
        authorities.add(new SimpleGrantedAuthority(Role.USER.name()));
        break;
      case INACTIVE:
        authorities.add(new SimpleGrantedAuthority(Role.INACTIVE.name()));
        break;
    }

    return authorities;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
