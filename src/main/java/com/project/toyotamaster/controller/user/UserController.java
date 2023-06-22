package com.project.toyotamaster.controller.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.toyotamaster.dto.UserUpdateProfileRequestDto;
import com.project.toyotamaster.entities.User;
import com.project.toyotamaster.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PutMapping("/updateProfile/{userId}")

	public User updateOneUser(@PathVariable Long userId, @RequestBody UserUpdateProfileRequestDto updateProfile) {
		return userService.updateProfile(userId, updateProfile);
	}
	

}
