package com.project.personal.jobchange.domain.post.dto;

import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "image_upload_info")
public class ImageUploadInfo {

  int postId;

  String imageName;

  String imagePath;

  int seq;
}