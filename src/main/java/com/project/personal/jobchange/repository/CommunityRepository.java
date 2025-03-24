package com.project.personal.jobchange.repository;

import com.project.personal.jobchange.entity.Community;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
  Optional<Community> findById(Long id);

}