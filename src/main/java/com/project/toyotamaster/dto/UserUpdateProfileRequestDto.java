package com.project.toyotamaster.dto;


import com.project.toyotamaster.entities.InformationDay;
import com.project.toyotamaster.entities.InformationService;
import com.project.toyotamaster.entities.TravelSystem;
import com.project.toyotamaster.entities.User;

import lombok.Data;

@Data
public class UserUpdateProfileRequestDto {
	
	private String username;
	private String department;
	private String departmentMnager;
	private String password;
	private InformationDay inforamtionDay;
	private TravelSystem travelSystem;
	private InformationService informationService;
	
	
	public void mapUserUpdateRequestDto(User user) {
		
		user.setUsername(this.getUsername());
		user.setDepartment(this.getDepartment());
		user.setDepartmentManager(this.getDepartmentMnager());
		user.setPassword(this.getPassword());
		user.setInformationDay(this.getInforamtionDay());
		user.setTravelSystem(this.getTravelSystem());
		user.setInformationService(this.getInformationService());
	}

}
