package com.project.toyotamaster.dto;

import com.project.toyotamaster.entities.Role;

import lombok.Data;

@Data
public class UserRegisterRequestDto {
	
	private String username;
	private String password;
	private Role role;
	

}
