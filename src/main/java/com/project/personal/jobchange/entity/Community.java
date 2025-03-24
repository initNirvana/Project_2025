package com.project.personal.jobchange.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Table(name = "community")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Community {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(nullable = false, updatable = false)
  String username;

  @Setter
  @Column(columnDefinition = "TEXT")
  String content;

  @Column(length = 20, nullable = false)
  String role;

  @Setter
  @Column(name = "refer_id")
  Long referId;

  @Column(name = "created_at", nullable = false, updatable = false)
  @CreationTimestamp
  LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  LocalDateTime updatedAt;

  // 빌더를 활용한 생성자
  @Builder
  public Community(
      String content,
      String username,
      String role,
      Long referId) {
    this.content = content;
    this.username = username;
    this.role = role;
    this.referId = referId;
  }

}
