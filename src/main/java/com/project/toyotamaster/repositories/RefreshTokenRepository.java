package com.project.toyotamaster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.toyotamaster.entities.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
	
	RefreshToken findByUserId(Long userId);

}
