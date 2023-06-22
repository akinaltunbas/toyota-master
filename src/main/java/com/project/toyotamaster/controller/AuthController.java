package com.project.toyotamaster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.toyotamaster.dto.AuthResponseDto;
import com.project.toyotamaster.dto.RefreshTokenRequestDto;
import com.project.toyotamaster.dto.UserLoginRequestDto;
import com.project.toyotamaster.dto.UserRegisterRequestDto;
import com.project.toyotamaster.entities.User;
import com.project.toyotamaster.security.JwtTokenProvider;
import com.project.toyotamaster.services.AuthServiceImpl;
import com.project.toyotamaster.services.RefreshTokenServiceImpl;
import com.project.toyotamaster.services.UserServiceImpl;



@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private AuthServiceImpl authService;
	

	public AuthController(AuthServiceImpl authService) {

		this.authService = authService;
	}

	@PostMapping("/register")
	public ResponseEntity<AuthResponseDto> register(@RequestBody UserRegisterRequestDto registerRequest) {
		return new ResponseEntity<>(authService.registerUser(registerRequest), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public AuthResponseDto login(@RequestBody UserLoginRequestDto loginRequest) {
		return authService.loginUser(loginRequest);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<AuthResponseDto> refresh(@RequestBody RefreshTokenRequestDto refreshRequest) {
			return new ResponseEntity<>(authService.refreshToken(refreshRequest), HttpStatus.OK);		
	} 	
}
