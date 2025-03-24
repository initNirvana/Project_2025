package com.project.personal.jobchange.domain.main.service;

import com.project.personal.jobchange.common.api.ServiceException;
import com.project.personal.jobchange.common.api.ServiceExceptionCode;
import com.project.personal.jobchange.entity.Community;
import com.project.personal.jobchange.repository.CommunityRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommunityService {

  private final CommunityRepository communityRepository;

  public List<Community> getAllPosts() {
    return communityRepository.findAll();
  }

  public Community getPost(Long id) {
    return communityRepository.findById(id)
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUND_POST));
  }

  public Community createPost(Community community) {
    return communityRepository.save(community);
  }

  @Transactional
  public Boolean delete(Long id) {
    communityRepository.findById(id)
        .orElseThrow(() -> new ServiceException(ServiceExceptionCode.NOT_FOUND_POST));

    communityRepository.deleteById(id);
    return true;
  }
}
