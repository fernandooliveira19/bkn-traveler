package com.fernando.oliveira.traveler.controller;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fernando.oliveira.traveler.service.TravelerService;

@WebMvcTest(controllers = TravelerController.class)
public class TravelerControllerTest {
	
	private static final String BASE_MAPPING = "";
	private static final String CREATE_TRAVELER = BASE_MAPPING + "";
	
	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	TravelerController controller;
	
	@MockBean
	TravelerService travelerService;
	
	public void shouldCreateTravelerAndReturnTravelerDetails() {
		
//		CreateTravelerRequest request = TravelerRequestMother.getCreateTravelerRequest();
//		CreateTravelerResponse response = TravelerResponseMother.getCreateTravelerResponse();
//		
//		Mockito.when(travelerService.createTraveler(request)).thenReturn(response);
				
	}

}
