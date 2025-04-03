package com.project.personal.jobchange.domain.user.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Builder
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  String userId;

  String password;

  String name;

  String phoneNumber;

  String email;

  Date birth;

  String profileMessage;

  String profileImageName;

  String profileImagePath;

  public User(
      int id,
      String userId,
      String password,
      String name,
      String phoneNumber,
      String email,
      Date birth,
      String profileMessage,
      String profileImageName,
      String profileImagePath
  ) {
    this.id = id;
    this.userId = userId;
    this.password = password;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.birth = birth;
    this.profileMessage = profileMessage;
    this.profileImageName = profileImageName;
    this.profileImagePath = profileImagePath;
  }
}
