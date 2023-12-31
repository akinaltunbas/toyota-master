package com.project.toyotamaster.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.toyotamaster.entities.Travel;

public interface TravelRepository extends JpaRepository<Travel, Long>{
	
	 List<Travel>  findTravelByUserId(Long UserId);
	
	 List<Travel> findByUsername(String username);
	 
	
	
	
}
