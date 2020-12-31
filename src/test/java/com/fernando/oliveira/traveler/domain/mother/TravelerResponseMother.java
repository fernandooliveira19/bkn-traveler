package com.fernando.oliveira.traveler.domain.mother;

import com.fernando.oliveira.traveler.domain.response.CreateTravelerResponse;

public class TravelerResponseMother {
	
	private TravelerResponseMother() {
		
	}
	
	private static final Long TRAVELER_ID = (long) 1;
	private static final String TRAVELER_NAME = "Joao da Silva";
	private static final String TRAVELER_EMAIL = "joao.silva@teste.com";
	
	private static final Long PHONE_ID = (long) 1;
	private static final Integer PREFIX_PHONE = 11;
	private static final String NUMBER_PHONE = "98888-7777";
	
	public static CreateTravelerResponse getCreateTravelerResponse() {
		
		CreateTravelerResponse response = new CreateTravelerResponse();
		response.setTravelerName(TRAVELER_NAME);
		response.setTravelerEmail(TRAVELER_EMAIL);
		response.setPrefixPhone(PREFIX_PHONE);
		response.setNumberPhone(NUMBER_PHONE);
		
		return response;
			
	}

}
