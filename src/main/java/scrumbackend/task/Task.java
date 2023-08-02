package scrumbackend.task;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  @Column(name = "task_today", columnDefinition = "TEXT")
  private String tasksToday;

  @Column(name = "task_yesterday", columnDefinition = "TEXT")
  private String tasksYesterday;

  @Column(name = "impediments", columnDefinition = "TEXT")
  private String impediments;

  @Builder.Default
  private boolean isResolved = false;

}