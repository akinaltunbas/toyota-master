package com.project.toyotamaster.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.project.toyotamaster.dto.UserCreateRequestDto;
import com.project.toyotamaster.dto.UserUpdateProfileRequestDto;
import com.project.toyotamaster.dto.UserUpdateRequestDto;
import com.project.toyotamaster.entities.User;

@Service
public interface UserService {
	
	public List<User> getAllUsers();
	
	public User createOneUser(UserCreateRequestDto newUserRequest);
	
	public void deleteOneUserById(Long userId);
	
	public User getOneUserById(Long userId);
	
	public User updateOneUserById(Long userId, UserUpdateRequestDto updateUserRequest);
	
	public User updateProfile(Long userId, UserUpdateProfileRequestDto updateProfile);
	
	public User getOneUserByUserName(String username);
	
	public User saveOneUser(User user);
	
}
