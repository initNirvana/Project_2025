package com.project.personal.jobchange.domain.repository;

import com.project.personal.jobchange.domain.post.dto.Post;
import com.project.personal.jobchange.domain.user.dto.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  void uploadPost(User user, String content, List<MultipartFile> images);

  Post getPost(int postId);

  List<Post> getPostsByUser(Long userId);

  void updatePost(User user, int postId, String content);

  void deletePost(User user, int postId);
}
