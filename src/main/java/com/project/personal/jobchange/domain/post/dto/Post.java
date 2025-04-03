package com.project.personal.jobchange.domain.post.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  String userId;

  String content;

  Date createTime;

  List<Image> images;

  public Post(
      int id,
      String userId,
      String content,
      Date createTime) {
    this.id = id;
    this.userId = userId;
    this.content = content;
    this.createTime = createTime;
  }
}