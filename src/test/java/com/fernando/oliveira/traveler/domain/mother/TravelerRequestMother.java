package com.fernando.oliveira.traveler.domain.mother;

import com.fernando.oliveira.traveler.domain.entity.Phone;
import com.fernando.oliveira.traveler.domain.entity.Traveler;
import com.fernando.oliveira.traveler.domain.request.CreateTravelerRequest;

public class TravelerRequestMother {
	
	private TravelerRequestMother() {
		
	}
	
	private static final String TRAVELER_NAME = "Joao da Silva";
	private static final String TRAVELER_EMAIL = "joao.silva@teste.com";
	private static final Integer PREFIX_PHONE = 11;
	private static final String NUMBER_PHONE = "98888-7777";
	
	public static CreateTravelerRequest getCreateTravelerRequest() {
		CreateTravelerRequest request = new CreateTravelerRequest();
		request.setTravelerName(TRAVELER_NAME);
		request.setTravelerEmail(TRAVELER_EMAIL);
		request.setPrefixPhone(PREFIX_PHONE);
		request.setNumberPhone(NUMBER_PHONE);
		return request;
	}
	
	public static Traveler getCreateTravelerRequestEntity() {
		Traveler traveler = new Traveler();
		traveler.setName(TRAVELER_NAME);
		traveler.setEmail(TRAVELER_EMAIL);
		
		Phone phone = new Phone();
		phone.setPrefix(PREFIX_PHONE);
		phone.setNumber(NUMBER_PHONE);
		
		traveler.setPhone(phone);
		
		return traveler;
	}

}
