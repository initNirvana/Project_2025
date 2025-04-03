package com.project.personal.jobchange.domain.post.controller;

import com.project.personal.jobchange.common.annotation.CheckLogin;
import com.project.personal.jobchange.common.annotation.CurrentUser;
import com.project.personal.jobchange.common.api.ApiResponse;
import com.project.personal.jobchange.common.api.ServiceException;
import com.project.personal.jobchange.common.api.ServiceExceptionCode;
import com.project.personal.jobchange.domain.post.dto.Post;
import com.project.personal.jobchange.domain.post.service.PostService;
import com.project.personal.jobchange.domain.repository.PostRepository;
import com.project.personal.jobchange.domain.repository.UserRepository;
import com.project.personal.jobchange.domain.user.dto.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Post/")
public class PostController {

  private final PostService postService;
  private final PostRepository postRepository;
  private final UserRepository userRepository;

  @GetMapping("/test")
  public ResponseEntity<Object> testApi() {
    String result = "API 통신에 asd.";
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping
  @CheckLogin
  public ApiResponse<ServiceExceptionCode> uploadPost(@RequestParam String content,
      @RequestPart("image") List<MultipartFile> images,
      @CurrentUser User currentUser) {

    postService.uploadPost(currentUser, content, images);
    return ApiResponse.Success(ServiceExceptionCode.RESPONSE_CREATED);
  }

  @GetMapping("/{postId}")
  @CheckLogin
  public ResponseEntity<Post> getPost(@PathVariable Long postId) {

    Post post = postRepository.findById(postId)
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.RESPONSE_NOT_FOUND));

    return ResponseEntity.ok(post);
  }

  @GetMapping
  @CheckLogin
  public ApiResponse<List<Post>> getUserFeed(@RequestParam(value = "userId") Long userId) {

    userRepository.findById(userId)
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.RESPONSE_NOT_FOUND));

    List<Post> posts = postService.getPostsByUser(userId);

    return ApiResponse.Success(posts);
  }

  @PatchMapping("/{postId}")
  @CheckLogin
  public ApiResponse<ServiceExceptionCode> updatePost(@PathVariable int postId,
      String content,
      @CurrentUser User currentUser) {
    // TO-DO : 인증
    postService.updatePost(currentUser, postId, content);
    return ApiResponse.Success(ServiceExceptionCode.RESPONSE_UPDATED);
  }

  @DeleteMapping("/{postId}")
  @CheckLogin
  public ApiResponse<ServiceExceptionCode> deletePost(@PathVariable int postId,
      @CurrentUser User currentUser) {
    // TO-DO : 인증
    postService.deletePost(currentUser, postId);

    return ApiResponse.Success(ServiceExceptionCode.RESPONSE_UPDATED);
  }
}