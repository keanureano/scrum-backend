package scrumbackend.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Task")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private Date createdAt;

  @UpdateTimestamp
  private Date updatedAt;

  private String tasksToday;
  private String tasksYesterday;
  private String impediments;

  @Builder.Default
  private boolean isResolved = false;
}
