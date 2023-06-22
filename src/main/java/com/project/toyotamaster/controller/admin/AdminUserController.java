package com.project.toyotamaster.controller.admin;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.toyotamaster.dto.UserCreateRequestDto;
import com.project.toyotamaster.dto.UserUpdateRequestDto;
import com.project.toyotamaster.entities.User;
import com.project.toyotamaster.services.UserService;
import com.project.toyotamaster.services.UserServiceImpl;


@RestController
@RequestMapping("/admin/user")
public class AdminUserController {
	
	
	private UserServiceImpl userService;
	

	public AdminUserController(UserServiceImpl userService) {
		this.userService = userService;
	}


	@GetMapping("/listUser")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}


	@PostMapping("/createUser")
	public User creteOneUser(@RequestBody UserCreateRequestDto newUserRequest) {
		return userService.createOneUser(newUserRequest);
	}
	
	@GetMapping("/getUser/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		return userService.getOneUserById(userId);
	}
	
	@PutMapping("/updateUser/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody UserUpdateRequestDto updateUser) {
		return userService.updateOneUserById(userId, updateUser);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteOneUserById(userId);
	}

	

}
