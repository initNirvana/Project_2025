package com.project.personal.jobchange.domain.main.controller;

import com.project.personal.jobchange.common.api.ApiResponse;
import com.project.personal.jobchange.domain.main.service.CommunityService;
import com.project.personal.jobchange.entity.Community;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class CommunityController {

  private final CommunityService communityService;

  @GetMapping("/test")
  public ResponseEntity<Object> testApi() {
    String result = "API 통신에 asd.";
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ApiResponse<Community> getPost(@PathVariable Long id) {
    return ApiResponse.Success(communityService.getPost(id));
  }

  @GetMapping
  public ApiResponse<List<Community>> getAllPostByUserId() {
    return ApiResponse.Success(communityService.getAllPosts());
  }

  @PostMapping
  public ApiResponse<Community> create(@RequestBody Community community) {
    return ApiResponse.Success(communityService.createPost(community));
  }

  @DeleteMapping("/{id}")
  public ApiResponse<Boolean> delete(@PathVariable Long id) {
    return ApiResponse.Success(communityService.delete(id));
  }

}