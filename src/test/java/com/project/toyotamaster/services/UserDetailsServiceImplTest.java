package com.project.toyotamaster.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.toyotamaster.entities.InformationDay;
import com.project.toyotamaster.entities.InformationService;
import com.project.toyotamaster.entities.Role;
import com.project.toyotamaster.entities.TravelSystem;
import com.project.toyotamaster.entities.User;
import com.project.toyotamaster.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTest {
	
	@InjectMocks
	private UserDetailsServiceImpl userService;
	
	@Mock
	private UserRepository userRepository;
	
	private User user;
	
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
	
	

	@DisplayName("JUnit test for loadUserByUsername")
	@Test
	public void testLoadUserByUsername() {
		
		
		//given
		given(userRepository.findByUsername("akın altunbas")).willReturn(user);
		given(userRepository.findByUsername(null));
				
		//when	
		UserDetails savedUser = userService.loadUserByUsername(user.getUsername());
		
		//then	
		assertThat(savedUser).isNotNull();
		
	}
	

	@DisplayName("JUnit test for loadUserById")
	@Test
	public void testLoadUserById() {
		
		//given
		given(userRepository.findById(1L));
		given(userRepository.findById(null));
				
		//when	
		UserDetails savedUser = userService.loadUserById(user.getId());
		
		//then	
		assertThat(savedUser).isNotNull();
		
	}

}
