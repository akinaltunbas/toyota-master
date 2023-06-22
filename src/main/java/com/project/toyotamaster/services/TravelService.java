package com.project.toyotamaster.services;

import java.util.Date;
import java.util.List;


import com.project.toyotamaster.dto.TravelCreateRequestDto;
import com.project.toyotamaster.dto.TravelUpdateRequestDto;
import com.project.toyotamaster.entities.Travel;

public interface TravelService {
	
public List<Travel> getAllTravels();
	
	public Travel createOneTravel(TravelCreateRequestDto newTravelRequest);
	
	public Travel updateOneTravelById(Long travelId, TravelUpdateRequestDto updateTravelRequest);
	
	public void deleteOneTravelById(Long travelId);
	
	public Travel getTravelById(Long TravelId);
	
	public List<Travel> getTravelSearch(Long userId); 
	
	public List<Travel> getTravelSearcByDate( Date startDate ,Date endDate);
	
	public List<Travel> getTravelSearchUsername(String username);

}
