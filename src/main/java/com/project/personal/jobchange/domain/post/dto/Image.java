package com.project.personal.jobchange.domain.post.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/*
@NoArgsConstructor(force = true)
: force 옵션을 true로 설정하면 final 필드를 0, false, null 등으로 초기화를 강제로 시켜 생성자를 만들 수 있다.
 */
@Getter
@Builder
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@Table(name = "image")
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  int postId;

  String imageName;

  String imagePath;

  int seq;
}