package com.fernando.oliveira.traveler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.oliveira.traveler.domain.entity.Phone;
import com.fernando.oliveira.traveler.repository.PhoneRepository;

@Service
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;
	
	public Phone save(Phone phone) {
		return phoneRepository.save(phone);
		
	}
		

}
