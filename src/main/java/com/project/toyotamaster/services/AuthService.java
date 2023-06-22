package com.project.toyotamaster.services;

import com.project.toyotamaster.dto.AuthResponseDto;
import com.project.toyotamaster.dto.RefreshTokenRequestDto;
import com.project.toyotamaster.dto.UserLoginRequestDto;
import com.project.toyotamaster.dto.UserRegisterRequestDto;


public interface AuthService {
	
	public AuthResponseDto loginUser(UserLoginRequestDto loginRequest);
	
	public AuthResponseDto registerUser(UserRegisterRequestDto registerRequest);
	
	public AuthResponseDto refreshToken(RefreshTokenRequestDto refreshRequest);
	
	

}
