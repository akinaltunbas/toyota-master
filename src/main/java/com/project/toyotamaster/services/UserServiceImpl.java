package com.project.toyotamaster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.toyotamaster.dto.UserCreateRequestDto;
import com.project.toyotamaster.dto.UserRegisterRequestDto;
import com.project.toyotamaster.dto.UserUpdateProfileRequestDto;
import com.project.toyotamaster.dto.UserUpdateRequestDto;
import com.project.toyotamaster.entities.User;
import com.project.toyotamaster.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;


	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User createOneUser(UserCreateRequestDto newUserRequest) {
		User user = new User();
		newUserRequest.mapUserCreateRequestDto(user);
		user.setPassword(passwordEncoder.encode(newUserRequest.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public void deleteOneUserById(Long userId) {
		userRepository.deleteById(userId);
		
	}

	@Override
	public User getOneUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public User updateOneUserById(Long userId, UserUpdateRequestDto updateUserRequest) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User user1 = user.get();
			updateUserRequest.mapUserUpdateRequestDto(user1);
			userRepository.save(user1);
			
			return user1;
		}
		return null;
	}

	@Override
	public User updateProfile(Long userId, UserUpdateProfileRequestDto updateProfile) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User user2 = user.get();
			updateProfile.mapUserUpdateRequestDto(user2);
			userRepository.save(user2);
			
			return user2;
		}
		return null;
	}
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveOneUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getOneUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}


}
