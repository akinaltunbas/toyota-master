package com.project.toyotamaster.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.toyotamaster.dto.UserCreateRequestDto;
import com.project.toyotamaster.dto.UserUpdateProfileRequestDto;
import com.project.toyotamaster.dto.UserUpdateRequestDto;
import com.project.toyotamaster.entities.InformationDay;
import com.project.toyotamaster.entities.InformationService;
import com.project.toyotamaster.entities.Role;
import com.project.toyotamaster.entities.TravelSystem;
import com.project.toyotamaster.entities.User;
import com.project.toyotamaster.repositories.UserRepository;
import com.project.toyotamaster.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private UserRepository userRepository;
	
	private User user;
	
	private PasswordEncoder bcryptEncoder;
	
	@BeforeEach
	public void setup() {
		
		user = User.builder()
				   .id(1L)
				   .username("akın altunbas")
				   .password("1234")
				  .department("Software")
				  .departmentManager("zehra altunbaş")
				  .travelSystem(TravelSystem.MONTHLY)
				  .role(Role.ADMIN)
				  .informationService(InformationService.OPEN)
				  .informationDay(InformationDay.FRIDAY)
				   .build();
	}
	
	
	@DisplayName("Junit test for deleteOneUserById method")
	@Test
	public void givenUserId_whenDeleteOneUser_thenNothing() {
		
		//given
		long userId = 1L;
		
		willDoNothing().given(userRepository).deleteById(userId);
		
		//when
		userService.deleteOneUserById(userId);
		
		//then
		verify(userRepository,times(1)).deleteById(userId);
	}
	
	@DisplayName("Junit test for getOneUserById")
	@Test
	public void givenUserId_whenGetUserById_thenReturnUser() {
		
		//given
		given(userRepository.findById(1L)).willReturn(Optional.of(user));
		
		//when
		User savedUser = userService.getOneUserById(user.getId());
		
		//then
		assertThat(savedUser).isNotNull();	
		
	}
	
	@DisplayName("Junit test for createOneUser")
	@Test
	public void givenUser_whenCreateUser_thenReturnUser() {
		
		//given
		UserCreateRequestDto userRequestDto = new UserCreateRequestDto();
		userRequestDto.setUsername("Test-Username");
		userRequestDto.setPassword("Test-Password");
	
		
		//when
		User userMock = Mockito.mock(User.class);
		when(userMock.getId()).thenReturn(1L);
		Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(userMock);
		User savedUser = userService.createOneUser(userRequestDto);
		
		//then
		assertEquals(savedUser.getId(),1L);
		
	}
	
	@DisplayName("Junit test for updateOneUserById method")
	@Test
	public void givenUser_whenUpdateUser_thenReturnUpdateUser() {
		
		//given
		UserUpdateRequestDto updateUserRequest = new UserUpdateRequestDto();
		long userId= 1L;
		given(userRepository.findById(1L)).willReturn(Optional.of(user));
		given (userRepository.save(user)).willReturn(user);
	
		updateUserRequest.setUsername("akito");
		updateUserRequest.setPassword("1234");
		updateUserRequest.setDepartment("IT");
		updateUserRequest.setDepartmentMnager("Anıl");
		updateUserRequest.setInformationDay(InformationDay.FRIDAY);
		updateUserRequest.setInformationService(InformationService.OPEN);
		updateUserRequest.setTravelSystem(TravelSystem.MONTHLY);
		
		//when
		User updateUser = userService.updateOneUserById(userId, updateUserRequest);
		
		//then
		
		assertThat(updateUser.getUsername()).isEqualTo("akito");
		assertThat(updateUser.getPassword()).isEqualTo("1234");
		assertThat(updateUser.getDepartment()).isEqualTo("IT");
		assertThat(updateUser.getDepartmentManager()).isEqualTo("Anıl");
		assertThat(updateUser.getInformationDay()).isEqualTo(InformationDay.MONDAY);
		assertThat(updateUser.getInformationService()).isEqualTo(InformationService.OPEN);
		assertThat(updateUser.getTravelSystem()).isEqualTo(TravelSystem.MONTHLY);

				
	}
	
	@DisplayName("Junit test for getAllUsers method")
	@Test
	public void givenUserList_whenGetAllUsers_thenReturnUserList() {
		
		//given
		User user = new User(1L,"Akın Altunbasş","1234","Software","Zehra Altunbas",Role.ADMIN,InformationDay.MONDAY,TravelSystem.MONTHLY,InformationService.OPEN);
		
		given(userRepository.findAll()).willReturn(List.of(user,user));
		
		//when
		List<User> userList = userService.getAllUsers();
		
		//then
		assertThat(userList).isNotNull();
		assertThat(userList.size()).isEqualTo(2);
	}
	
	@DisplayName("Junit test for getOneUserByUserName method")
	@Test
	public void givenUserName_whenGetUserName_thenReturnUser() {
		
		//given
		given(userRepository.findByUsername("akın altunbas")).willReturn(user);
		
		//when
		User savedUser = userService.getOneUserByUserName(user.getUsername());
		
		//then
		assertThat(savedUser).isNotNull();
	}
	
	
	@DisplayName("Junit test for updateProfile method")
	@Test
	public void givenUser_whenUpdateProfile_thenReturnUpdateProfile() {
		
		//given
		UserUpdateProfileRequestDto updateProfileRequest = new UserUpdateProfileRequestDto();
		long userId= 1L;
		given(userRepository.findById(1L)).willReturn(Optional.of(user));
		given (userRepository.save(user)).willReturn(user);
	
		updateProfileRequest.setUsername("akito");
		updateProfileRequest.setPassword("1234");
		updateProfileRequest.setDepartment("IT");
		updateProfileRequest.setDepartmentMnager("Anıl");
		updateProfileRequest.setInforamtionDay(InformationDay.MONDAY);
		updateProfileRequest.setInformationService(InformationService.OPEN);
		updateProfileRequest.setTravelSystem(TravelSystem.MONTHLY);
		
		//when
		User updateUser = userService.updateProfile(userId, updateProfileRequest);
		
		//then
		
		assertThat(updateUser.getUsername()).isEqualTo("akito");
		assertThat(updateUser.getPassword()).isEqualTo("1234");
		assertThat(updateUser.getDepartment()).isEqualTo("IT");
		assertThat(updateUser.getDepartmentManager()).isEqualTo("Anıl");
		assertThat(updateUser.getInformationDay()).isEqualTo(InformationDay.MONDAY);
		assertThat(updateUser.getInformationService()).isEqualTo(InformationService.OPEN);
		assertThat(updateUser.getTravelSystem()).isEqualTo(TravelSystem.MONTHLY);

				
	}
	
	@DisplayName("Junit test for saveOneUser")
	@Test
	public void givenUser_whenSaveUser_thenReturnUser() {
		
		//given
		given(userRepository.save(user)).willReturn(user);
		
		//when
		User savedUser = userService.saveOneUser(user);
		
		//then
		assertThat(savedUser).isNotNull();
		
	}
	

}
