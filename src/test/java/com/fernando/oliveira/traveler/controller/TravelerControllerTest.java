package com.fernando.oliveira.traveler.controller;

import com.fernando.oliveira.traveler.domain.entity.Traveler;
import com.fernando.oliveira.traveler.domain.mapper.TravelerMapper;
import com.fernando.oliveira.traveler.domain.mother.TravelerMother;
import com.fernando.oliveira.traveler.domain.request.TravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;
import com.fernando.oliveira.traveler.service.impl.TravelerServiceImpl;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
//@SpringBootTest
@WebMvcTest(controllers = TravelerController.class)
public class TravelerControllerTest {
	
	private static final String BASE_MAPPING = "/v1/travelers";
	private static final String CREATE_TRAVELER = BASE_MAPPING ;
	
	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	TravelerController controller;
	
	@MockBean
	TravelerServiceImpl travelerService;

	@MockBean
	TravelerMapper mapper;
	
	@Test
	public void shouldCreateTravelerAndReturnTravelerDetails() throws Exception {
		
		TravelerRequest request = TravelerMother.getCreateTravelerRequest();
		Traveler travelerToSave = TravelerMother.getTraveler();
		Traveler travelerSaved = TravelerMother.getTraveler();
		travelerSaved.setId("1234");
		travelerSaved.setStatus("A");
		TravelerDetailResponse response = TravelerMother.getCreateTravelerResponse();

		Mockito.when(mapper.requestToTraveler(Mockito.any(TravelerRequest.class))).thenReturn(travelerToSave);
		Mockito.when(travelerService.createTraveler(Mockito.any(Traveler.class))).thenReturn(travelerSaved);
		Mockito.when(mapper.travelerToTravelerDetailResponse(Mockito.any(Traveler.class))).thenReturn(response);

		String requestJson = TravelerMother.getCreateRequestJsonValue(request);
		mockMvc.perform(post(CREATE_TRAVELER)
				.header("Content-Type", ContentType.APPLICATION_JSON)
				.content(requestJson))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name").value(response.getName()));

	}

	@Test
	public void shouldReturnTravelerById() throws Exception {


		Traveler travelerSaved = TravelerMother.getTraveler();
		travelerSaved.setId("1234");
		travelerSaved.setStatus("A");

		TravelerDetailResponse response = TravelerMother.getDetailTravelerResponse();

		Mockito.when(travelerService.findById("1234")).thenReturn(travelerSaved);
		Mockito.when(mapper.travelerToTravelerDetailResponse(Mockito.any(Traveler.class))).thenReturn(response);

		mockMvc.perform(get(BASE_MAPPING +"/1234")
				.header("Content-Type", ContentType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value(response.getName()));

	}

	@Test
	public void shouldReturnAllTravelers() throws Exception {


		Traveler travelerSaved = TravelerMother.getTraveler();
		travelerSaved.setId("1234");
		travelerSaved.setStatus("A");

		TravelerDetailResponse response = TravelerMother.getDetailTravelerResponse();

		Mockito.when(travelerService.findAll()).thenReturn(Arrays.asList(travelerSaved));
		Mockito.when(mapper.travelerToTravelerDetailResponse(Mockito.any(Traveler.class))).thenReturn(response);

		mockMvc.perform(get(BASE_MAPPING )
				.header("Content-Type", ContentType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value(response.getName()));

	}

}
