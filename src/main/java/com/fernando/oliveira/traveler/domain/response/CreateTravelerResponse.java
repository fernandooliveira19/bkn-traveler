package com.fernando.oliveira.traveler.domain.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTravelerResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String travelerName;
	private String travelerEmail;
	private Integer prefixPhone;
	private String numberPhone;

}
