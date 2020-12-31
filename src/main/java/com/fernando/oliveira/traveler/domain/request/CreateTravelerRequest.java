package com.fernando.oliveira.traveler.domain.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTravelerRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String travelerName;
	private String travelerEmail;
	private Integer prefixPhone;
	private String numberPhone;
	

}
