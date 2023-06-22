package com.project.toyotamaster.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.toyotamaster.entities.Travel;

public interface TravelRepository extends JpaRepository<Travel, Long>{
	
	 List<Travel>  findTravelByUserId(Long UserId);
	
	 List<Travel> findByUsername(String username);
	 
	 @Query(value = "SELECT t FROM travels t WHERE t.travel_start BETWEEN startDate AND endDate", nativeQuery = true)
	 List<Travel> findTravelByDate(Date startDate, Date endDate);
	
	
}
