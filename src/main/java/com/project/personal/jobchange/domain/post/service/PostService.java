package com.project.personal.jobchange.domain.post.service;

import com.project.personal.jobchange.domain.post.dto.Post;
import com.project.personal.jobchange.domain.repository.PostRepository;
import com.project.personal.jobchange.domain.user.dto.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  public void uploadPost(User user, String content, List<MultipartFile> images) {
    postRepository.uploadPost(user, content, images);
  }

  public Post getPost(int postId) {
    return postRepository.getPost(postId);
  }

  public List<Post> getPostsByUser(Long userId) {
    return postRepository.getPostsByUser(userId);
  }

  public void updatePost(User user, int postId, String content) {
    postRepository.updatePost(user, postId, content);
  }

  public void deletePost(User user, int postId) {
    postRepository.deletePost(user, postId);
  }
}