package com.fernando.oliveira.traveler.controller;

import com.fernando.oliveira.traveler.domain.dto.CreateTravelerRequestDto;
import com.fernando.oliveira.traveler.domain.dto.TravelerDetailResponseDto;
import com.fernando.oliveira.traveler.domain.mapper.TravelerMapper;
import com.fernando.oliveira.traveler.domain.mother.TravelerMother;
import com.fernando.oliveira.traveler.domain.request.CreateTravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;
import com.fernando.oliveira.traveler.service.impl.TravelerServiceImpl;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

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
		
		CreateTravelerRequest request = TravelerMother.getCreateTravelerRequest();
		CreateTravelerRequestDto requestDto = TravelerMother.getCreateTravelerRequestDto();
		TravelerDetailResponseDto responseDto = TravelerMother.getTravelerDetailResponseDto();
		responseDto.setStatus("A");
		TravelerDetailResponse response = TravelerMother.getCreateTravelerResponse();

		Mockito.when(mapper.createTravelerRequestToDto(Mockito.any(CreateTravelerRequest.class))).thenReturn(requestDto);
		Mockito.when(travelerService.createTraveler(Mockito.any(CreateTravelerRequestDto.class))).thenReturn(responseDto);
		Mockito.when(mapper.detailResponseDtoToResponse(Mockito.any(TravelerDetailResponseDto.class))).thenReturn(response);

		String requestJson = TravelerMother.getCreateRequestJsonValue(request);
		mockMvc.perform(post(CREATE_TRAVELER)
				.header("Content-Type", ContentType.APPLICATION_JSON)
				.content(requestJson))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.name").value(response.getName()));

	}

}
