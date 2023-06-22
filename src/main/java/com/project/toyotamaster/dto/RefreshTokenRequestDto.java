package com.project.toyotamaster.dto;

import lombok.Data;

@Data
public class RefreshTokenRequestDto {
	
	Long userId;
	String refreshToken;

}
