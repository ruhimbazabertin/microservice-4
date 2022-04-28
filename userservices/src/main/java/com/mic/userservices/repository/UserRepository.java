package com.mic.userservices.repository;

import com.mic.userservices.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
