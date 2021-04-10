package com.fernando.oliveira.traveler.exception;

import java.util.function.Supplier;

public class TravelerNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public TravelerNotFoundException (String message) {
		super(message);
	}


}