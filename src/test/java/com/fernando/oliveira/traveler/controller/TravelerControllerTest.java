package com.fernando.oliveira.traveler.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fernando.oliveira.traveler.domain.mother.TravelerMother;
import com.fernando.oliveira.traveler.domain.request.TravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;
import com.fernando.oliveira.traveler.service.impl.TravelerServiceImpl;

@WebMvcTest(controllers = TravelerController.class)
public class TravelerControllerTest {
	
	private static final String BASE_MAPPING = "/travelers";
	private static final String CREATE_TRAVELER = BASE_MAPPING ;
	
	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	TravelerController controller;
	
	@MockBean
	TravelerServiceImpl travelerService;
	
	@Test
	public void shouldCreateTravelerAndReturnTravelerDetails() {
		
		TravelerRequest request = TravelerMother.getCreateTravelerRequest();
		TravelerDetailResponse response = TravelerMother.getCreateTravelerResponse();
		
		Mockito.when(travelerService.createTraveler(request)).thenReturn(response);
				
	}

}
