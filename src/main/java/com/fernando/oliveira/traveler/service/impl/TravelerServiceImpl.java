package com.fernando.oliveira.traveler.service.impl;

import com.fernando.oliveira.traveler.client.TravelerClient;
import com.fernando.oliveira.traveler.domain.dto.CreateTravelerRequestDto;
import com.fernando.oliveira.traveler.domain.dto.TravelerDetailResponseDto;
import com.fernando.oliveira.traveler.domain.enums.Status;
import com.fernando.oliveira.traveler.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelerServiceImpl implements TravelerService{

	@Autowired
	private TravelerClient client;
	

	public TravelerDetailResponseDto createTraveler(CreateTravelerRequestDto requestDto) {
		
		requestDto.setStatus(Status.ACTIVE.getCode());

		TravelerDetailResponseDto responseDto = client.createTraveler(requestDto);
		
		return responseDto;
	}

	@Override
	public List<TravelerDetailResponseDto> findTravelersByNameOrEmail(String name, String email) {
		List result = new ArrayList();
		List<TravelerDetailResponseDto> travelersByName = client.findTravelersByName(name);
		result.add(travelersByName);
		List<TravelerDetailResponseDto> travelersByEmail = client.findTravelersByEmail(email);
		result.add(travelersByEmail);

		return result;
	}

}
