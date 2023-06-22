package com.project.toyotamaster.dto;

import java.util.Date;

import com.project.toyotamaster.entities.Travel;
import com.project.toyotamaster.entities.User;

import lombok.Data;

@Data
public class TravelUpdateRequestDto {
	
	private String travelDestination;
	private String purposeOfGoing;
	private String projectCode ;
	private Date travelStart;
	private Date travelEnd;
	private String travelCost;
	private String username;
	private User user ;
	
	public void mapTravelCreateRequestDto(Travel travel) {
		
		travel.setTravelDestination(this.getTravelDestination());
		travel.setPurposeOfGoing(this.getPurposeOfGoing());
		travel.setProjectCode(this.getProjectCode());
		travel.setTravelStart(this.getTravelStart());
		travel.setTravelEnd(this.getTravelEnd());
		travel.setUsername(this.getUsername());
		travel.setTravelCost(this.getTravelCost());
	}

}
