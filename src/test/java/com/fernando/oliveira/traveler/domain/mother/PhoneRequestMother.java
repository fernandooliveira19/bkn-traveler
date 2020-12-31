package com.fernando.oliveira.traveler.domain.mother;

import com.fernando.oliveira.traveler.domain.entity.Phone;

public class PhoneRequestMother {
	
	private PhoneRequestMother() {
		
	}

	private static final Integer PREFIX = 11;
	private static final String NUMBER = "98888-6777";
	
	
	public static Phone getPhoneRequest() {
		Phone request = new Phone();
		request.setNumber(NUMBER);
		request.setPrefix(PREFIX);
		return request;
	}
}
