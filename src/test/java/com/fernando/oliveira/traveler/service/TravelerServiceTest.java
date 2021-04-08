package com.fernando.oliveira.traveler.service;

import com.fernando.oliveira.traveler.client.TravelerClient;
import com.fernando.oliveira.traveler.domain.dto.CreateTravelerRequestDto;
import com.fernando.oliveira.traveler.domain.dto.TravelerDetailResponseDto;
import com.fernando.oliveira.traveler.domain.enums.Status;
import com.fernando.oliveira.traveler.domain.mother.TravelerMother;
import com.fernando.oliveira.traveler.service.impl.TravelerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class TravelerServiceTest {
	
	@InjectMocks
	TravelerServiceImpl service;

	@Mock
	TravelerClient client;
	

	@Test
	public void shouldCreateTravelerAndReturnTravelerDetails() {
		
		CreateTravelerRequestDto requestDto = TravelerMother.getCreateTravelerRequestDto();
		TravelerDetailResponseDto responseDto = TravelerMother.getTravelerDetailResponseDto();
		responseDto.setStatus("A");
		
		Mockito.when(client.createTraveler(requestDto)).thenReturn(responseDto);

		TravelerDetailResponseDto result = service.createTraveler(requestDto);

		Assertions.assertNotNull(result.getId());
		Assertions.assertEquals(responseDto.getId(),result.getId());
		Assertions.assertEquals(responseDto.getName(),result.getName() );
		Assertions.assertEquals(responseDto.getEmail(), result.getEmail() );

		Assertions.assertEquals(Status.ACTIVE.getCode(), result.getStatus());
		Assertions.assertEquals(responseDto.getPrefixPhone(), result.getPrefixPhone());
		Assertions.assertEquals(responseDto.getNumberPhone(),result.getNumberPhone() );
		
	}

	@Test
	public void shouldReturnTravelerListByNameOrEmail(){

		TravelerDetailResponseDto responseDto = TravelerMother.getTravelerDetailResponseDto();
		List<TravelerDetailResponseDto> responseDtoList = Arrays.asList(responseDto);
		String name = "Joao da Silva";
		String email = "joao.silva@teste.com";

		Mockito.when(client.findTravelersByName(name)).thenReturn(responseDtoList);

		List<TravelerDetailResponseDto> result = service.findTravelersByNameOrEmail(name, email);

		Assertions.assertFalse(result.isEmpty());

	}
	

}
