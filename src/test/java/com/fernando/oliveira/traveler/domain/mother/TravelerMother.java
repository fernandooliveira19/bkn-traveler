package com.fernando.oliveira.traveler.domain.mother;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fernando.oliveira.traveler.domain.dto.CreateTravelerRequestDto;
import com.fernando.oliveira.traveler.domain.dto.TravelerDetailResponseDto;
import com.fernando.oliveira.traveler.domain.request.CreateTravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;

public class TravelerMother {
	
	private TravelerMother() {
		
	}
	
	private static final Long TRAVELER_ID = (long) 1;
	private static final String TRAVELER_NAME = "Joao da Silva";
	private static final String TRAVELER_EMAIL = "joao.silva@teste.com";
	private static final String TRAVELER_DOCUMENT = "12345678900";
	

	private static final Integer PREFIX_PHONE= 11;
	private static final String NUMBER_PHONE = "98888-7777";
	
	public static CreateTravelerRequest getCreateTravelerRequest() {
		CreateTravelerRequest request = new CreateTravelerRequest();
		request.setName(TRAVELER_NAME);
		request.setEmail(TRAVELER_EMAIL);
		request.setPrefixPhone(PREFIX_PHONE);
		request.setNumberPhone(NUMBER_PHONE);
		return request;
	}
	

	
	public static TravelerDetailResponse getCreateTravelerResponse() {
		
		TravelerDetailResponse response = new TravelerDetailResponse();
		response.setName(TRAVELER_NAME);
		response.setEmail(TRAVELER_EMAIL);
		response.setPrefixPhone(PREFIX_PHONE);
		response.setNumberPhone(NUMBER_PHONE);
		response.setId(TRAVELER_ID);
		
		return response;
			
	}
	public static CreateTravelerRequestDto getCreateTravelerRequestDto() {
		CreateTravelerRequestDto requestDto = new CreateTravelerRequestDto();
		requestDto.setName(TRAVELER_NAME);
		requestDto.setEmail(TRAVELER_EMAIL);
		requestDto.setPrefixPhone(PREFIX_PHONE);
		requestDto.setNumberPhone(NUMBER_PHONE);
		return requestDto;
	}


	public static TravelerDetailResponseDto getTravelerDetailResponseDto() {
		return TravelerDetailResponseDto.builder()
				.id(TRAVELER_ID)
				.name(TRAVELER_NAME)
				.email(TRAVELER_EMAIL)
				.document(TRAVELER_DOCUMENT)
				.prefixPhone(PREFIX_PHONE)
				.numberPhone(NUMBER_PHONE)
				.build();
	}

    public static String getCreateRequestJsonValue(CreateTravelerRequest request) throws JsonProcessingException {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter writer = mapper.writer().withDefaultPrettyPrinter();
        return writer.writeValueAsString(request);
    }
}
