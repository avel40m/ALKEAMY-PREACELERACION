package com.alkeamy.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkeamy.auth.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
	UserEntity findByUsername(String username);
}
