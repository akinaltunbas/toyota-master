package com.project.toyotamaster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.toyotamaster.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String useranme);
}
