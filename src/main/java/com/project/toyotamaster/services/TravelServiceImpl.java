package com.project.toyotamaster.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.toyotamaster.dto.TravelCreateRequestDto;
import com.project.toyotamaster.dto.TravelUpdateRequestDto;
import com.project.toyotamaster.entities.Travel;
import com.project.toyotamaster.repositories.TravelRepository;


@Service
public class TravelServiceImpl implements TravelService{
	
	private TravelRepository travelRepository;
	
	public TravelServiceImpl(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}


	@Override
	public List<Travel> getAllTravels() {
		return travelRepository.findAll();
	}

	@Override
	public Travel createOneTravel(TravelCreateRequestDto newTravelRequest) {
		Travel travel = new Travel();
		newTravelRequest.mapTravelCreateRequestDto(travel);
		return travelRepository.save(travel);
	}

	@Override
	public Travel updateOneTravelById(Long travelId, TravelUpdateRequestDto updateTravelRequest) {
		Optional<Travel> travel = travelRepository.findById(travelId);
		if(travel.isPresent()) {
			Travel travel1 = travel.get();
			updateTravelRequest.mapTravelCreateRequestDto(travel1);
			travelRepository.save(travel1);
			
			return travel1;
		}
		return null;
	}


	@Override
	public void deleteOneTravelById(Long travelId) {
		travelRepository.deleteById(travelId);
		
	}

	@Override
	public Travel getTravelById(Long travelId) {
		return travelRepository.findById(travelId).orElse(null);
	}

	@Override
	public List<Travel> getTravelSearch(Long userId) {
		
		return travelRepository.findTravelByUserId(userId);
	}

	@Override
	public List<Travel> getTravelSearcByDate(Date startDate,Date endDate) {
		return travelRepository.findTravelByDate(startDate, endDate);
	}


	@Override
	public List<Travel> getTravelSearchUsername(String username) {
		return travelRepository.findByUsername(username);
	}

}
