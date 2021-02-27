package com.fernando.oliveira.traveler.domain.mother;

import java.util.Optional;

import com.fernando.oliveira.traveler.domain.entity.Phone;
import com.fernando.oliveira.traveler.domain.entity.Traveler;
import com.fernando.oliveira.traveler.domain.request.TravelerRequest;
import com.fernando.oliveira.traveler.domain.request.UpdateTravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;

public class TravelerMother {
	
	private TravelerMother() {
		
	}
	
	private static final Long TRAVELER_ID = (long) 1;
	private static final String TRAVELER_NAME = "Joao da Silva";
	private static final String TRAVELER_EMAIL = "joao.silva@teste.com";
	
	private static final Long PHONE_ID = (long) 1;
	private static final Integer PREFIX_PHONE= 11;
	private static final String NUMBER_PHONE = "98888-7777";
	
	public static TravelerRequest getCreateTravelerRequest() {
		TravelerRequest request = new TravelerRequest();
		request.setTravelerName(TRAVELER_NAME);
		request.setTravelerEmail(TRAVELER_EMAIL);
		request.setPrefixPhone(PREFIX_PHONE);
		request.setNumberPhone(NUMBER_PHONE);
		return request;
	}
	
	public static Traveler getTravelerToSave() {
		Traveler traveler = new Traveler();
		traveler.setName(TRAVELER_NAME);
		traveler.setEmail(TRAVELER_EMAIL);
		
		Phone phone = new Phone();
		phone.setPrefix(PREFIX_PHONE);
		phone.setNumber(NUMBER_PHONE);
		
		traveler.setPhone(phone);
		
		return traveler;
	}
	
	public static TravelerDetailResponse getCreateTravelerResponse() {
		
		TravelerDetailResponse response = new TravelerDetailResponse();
		response.setTravelerName(TRAVELER_NAME);
		response.setTravelerEmail(TRAVELER_EMAIL);
		response.setPrefixPhone(PREFIX_PHONE);
		response.setNumberPhone(NUMBER_PHONE);
		response.setId(TRAVELER_ID);
		
		return response;
			
	}

	public static Traveler getTravelerSaved() {
		Traveler traveler = new Traveler();
		traveler.setName(TRAVELER_NAME);
		traveler.setEmail(TRAVELER_EMAIL);
		traveler.setId(TRAVELER_ID);
		
		Phone phone = new Phone();
		phone.setId(PHONE_ID);
		phone.setPrefix(PREFIX_PHONE);
		phone.setNumber(NUMBER_PHONE);
		
		traveler.setPhone(phone);
		
		return traveler;
	}

	public static TravelerRequest getUpdateTravelerRequest() {
		TravelerRequest request = new TravelerRequest();
		request.setId(TRAVELER_ID);
		request.setTravelerName(TRAVELER_NAME);
		request.setTravelerEmail(TRAVELER_EMAIL);
		request.setPrefixPhone(PREFIX_PHONE);
		request.setNumberPhone(NUMBER_PHONE);
		
		return request;
	}

	public static Traveler getTravelerToUpdate() {
		Traveler traveler = new Traveler();
		traveler.setName(TRAVELER_NAME);
		traveler.setEmail(TRAVELER_EMAIL);
		traveler.setId(TRAVELER_ID);
		
		Phone phone = new Phone();
		phone.setId(PHONE_ID);
		phone.setPrefix(PREFIX_PHONE);
		phone.setNumber(NUMBER_PHONE);
		
		traveler.setPhone(phone);
		return traveler;
	}

	public static Traveler getTravelerUpdated() {
		Traveler traveler = new Traveler();
		traveler.setName(TRAVELER_NAME);
		traveler.setEmail(TRAVELER_EMAIL);
		traveler.setId(TRAVELER_ID);
		
		Phone phone = new Phone();
		phone.setId(PHONE_ID);
		phone.setPrefix(PREFIX_PHONE);
		phone.setNumber(NUMBER_PHONE);
		
		traveler.setPhone(phone);
		return traveler;
	}

	public static TravelerDetailResponse getUpdateTravelerResponse() {
		TravelerDetailResponse response = new TravelerDetailResponse();
		response.setTravelerName(TRAVELER_NAME);
		response.setTravelerEmail(TRAVELER_EMAIL);
		response.setPrefixPhone(PREFIX_PHONE);
		response.setNumberPhone(NUMBER_PHONE);
		response.setId(TRAVELER_ID);
		
		return response;
	}

	public static Optional<Traveler> getOptionalTravelerResponse() {
		Traveler traveler = new Traveler();
		traveler.setName(TRAVELER_NAME);
		traveler.setEmail(TRAVELER_EMAIL);
		traveler.setId(TRAVELER_ID);
		
		Phone phone = new Phone();
		phone.setId(PHONE_ID);
		phone.setPrefix(PREFIX_PHONE);
		phone.setNumber(NUMBER_PHONE);
		
		traveler.setPhone(phone);
		return Optional.of(traveler);
	
	}

}
