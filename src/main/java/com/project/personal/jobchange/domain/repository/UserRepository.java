package com.project.personal.jobchange.domain.repository;

import com.project.personal.jobchange.domain.user.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
