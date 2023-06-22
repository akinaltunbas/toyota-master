package com.project.toyotamaster.controller.user;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.toyotamaster.dto.TravelCreateRequestDto;
import com.project.toyotamaster.dto.TravelUpdateRequestDto;
import com.project.toyotamaster.entities.Travel;
import com.project.toyotamaster.services.TravelService;
import com.project.toyotamaster.services.TravelServiceImpl;

@RestController
@RequestMapping("/user/travel")
public class UserTravelController {
	
	private TravelServiceImpl travelService;
	
	
	public UserTravelController(TravelServiceImpl travelService) {
		this.travelService = travelService;
	}

	@DeleteMapping("/deleteTravel/{travelId}")
	public void deleteTravel(@PathVariable Long travelId) {
		travelService.deleteOneTravelById(travelId);
		
	}
	
	@PostMapping("/createTravel")
	public Travel creteOneUserTravel(@RequestBody TravelCreateRequestDto newTravelRequest) {
		return travelService.createOneTravel(newTravelRequest);
	}
	
	@PutMapping("/updateTravel/{travelId}")
	public Travel updateOneTravel(@PathVariable Long travelId, @RequestBody TravelUpdateRequestDto updateTravel) {
		return travelService.updateOneTravelById(travelId, updateTravel);
	}
	
	@GetMapping("/searcTravel")
	public List<Travel> searchTravel(@RequestParam Long userId){
		return travelService.getTravelSearch(userId);
		
	}
	

}
