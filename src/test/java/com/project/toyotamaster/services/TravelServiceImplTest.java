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

import com.project.toyotamaster.dto.TravelCreateRequestDto;
import com.project.toyotamaster.dto.TravelUpdateRequestDto;
import com.project.toyotamaster.entities.Travel;
import com.project.toyotamaster.entities.User;
import com.project.toyotamaster.repositories.TravelRepository;


@ExtendWith(MockitoExtension.class)
public class TravelServiceImplTest {
	
	@InjectMocks
	private TravelServiceImpl travelService;
	
	@Mock
	private TravelRepository travelRepository;
	
	private Travel travel;
	
	@BeforeEach
	public void setup() {
		
		travel = Travel.builder()
			   .id(1L)
			   .projectCode(" AA")
			   .purposeOfGoing("Turist")
			   .travelCost("1000")
			   .travelDestination("Ankara")
			   .travelEnd(null)
			   .travelStart(null)
			   .username("Akın Altunbaş")
			   .build();
	}
	
	@DisplayName("junit test for deleteOneTravelById method")
	@Test
	public void givenTravelId_whenDeleteOneTravel_thenNothing() {
		
		//given
		long travelId = 1L;
		
		willDoNothing().given(travelRepository).deleteById(travelId);
		
		//when
		travelService.deleteOneTravelById(travelId);
		
		//then
		verify(travelRepository, times(1)).deleteById(travelId);
		
	}
	
	@DisplayName("Jnit test for getAllTravels method")
	@Test
	public void givenTravelList_whenGetAllTravels_thenReturnTravelList() {
		
		//given
	Travel	travel1 = Travel.builder()
				   .id(1L)
				   .projectCode(" AA")
				   .purposeOfGoing("Turist")
				   .travelCost("1000")
				   .travelDestination("Ankara")
				   .travelEnd(null)
				   .travelStart(null)
				   .username("Akın Altunbaş")
				   .build();
	Travel	travel2 = Travel.builder()
				   .id(1L)
				   .projectCode(" BBB")
				   .purposeOfGoing("Turist")
				   .travelCost("1000")
				   .travelDestination("Ankara")
				   .travelEnd(null)
				   .travelStart(null)
				   .username("Zhra Altunbaş")
				   .build();
		given(travelRepository.findAll()).willReturn(List.of(travel1,travel2));
		
		//when
		List<Travel> travelList = travelService.getAllTravels();
		
		//then
		assertThat(travelList).isNotNull();
		assertThat(travelList.size()).isEqualTo(2);
	}
	
	@DisplayName("JUnit test for updateOneTravelById method")
	@Test
	public void givenTravel_whenUpdateTravel_thenReturnUpdateTravel() {
		
		//given
		TravelUpdateRequestDto updateTravelRequest = new TravelUpdateRequestDto();
		Long travelId = 1L;
		given(travelRepository.findById(1L)).willReturn(Optional.of(travel));
		given(travelRepository.save(travel)).willReturn(travel);
		
		//when
		Travel updateTravel = travelService.updateOneTravelById(travelId, updateTravelRequest);
		
		updateTravel.setUsername("akito");
		updateTravel.setProjectCode("AAA");
		updateTravel.setPurposeOfGoing("Turist");
		updateTravel.setTravelCost("1000tl");
		updateTravel.setTravelDestination("Ankara");
		updateTravel.setTravelEnd(null);
		updateTravel.setTravelStart(null);
		
		//then
		assertThat(updateTravelRequest.getUsername()).isEqualTo("akın altunbas");
		assertThat(updateTravelRequest.getProjectCode()).isEqualTo("AAA");
		assertThat(updateTravelRequest.getPurposeOfGoing()).isEqualTo("Turist");
		assertThat(updateTravelRequest.getTravelCost()).isEqualTo("1000tl");
		assertThat(updateTravelRequest.getTravelDestination()).isEqualTo("Ankara");
		assertThat(updateTravelRequest.getTravelStart()).isEqualTo("2023-03-06 22:00:00");
		assertThat(updateTravelRequest.getTravelEnd()).isEqualTo("2023-03-08 22:00:00");
	}
	
	@DisplayName("JUnit test for createOneRole")
	@Test
	public void givenRole_whenCreateRole_thenReturnRole() {
		
		//given
		TravelCreateRequestDto travelRequestDto = new TravelCreateRequestDto();
		travelRequestDto.setProjectCode("Test");
		travelRequestDto.setPurposeOfGoing("Test");
		travelRequestDto.setTravelCost("Test");
		travelRequestDto.setTravelDestination("Test");
		travelRequestDto.setTravelEnd(null);
		travelRequestDto.setTravelStart(null);
		travelRequestDto.setUsername("Test");
		
		//when
		Travel travelMock = Mockito.mock(Travel.class);
		when(travelMock.getId()).thenReturn(1L);
		Mockito.when(travelRepository.save(ArgumentMatchers.any(Travel.class))).thenReturn(travelMock);
		
		Travel savedTravel = travelService.createOneTravel(travelRequestDto);

		//then
		assertEquals(savedTravel.getId(),1L);
	}
	
	@DisplayName("JUnit test for getRoleTravelId")
	@Test
	public void givenRoleId_whenGetRoleById_thenReturnRole() {
		
		// given
		travel = Travel.builder()
				   .id(1L)
				   .projectCode(" AA")
				   .purposeOfGoing("Turist")
				   .travelCost("1000")
				   .travelDestination("Ankara")
				   .travelEnd(null)
				   .travelStart(null)
				   .username("Akın Altunbaş")
				   .build();
			
		given(travelRepository.findById(1L)).willReturn(Optional.of(travel));
		
		// when
		Travel savedTravel = travelService.getTravelById(travel.getId());
		
		//then
		assertThat(savedTravel).isNotNull();
	}

}
