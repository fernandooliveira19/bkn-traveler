package com.fernando.oliveira.traveler.service;

import com.fernando.oliveira.traveler.domain.dto.CreateTravelerRequestDto;
import com.fernando.oliveira.traveler.domain.dto.TravelerDetailResponseDto;

import java.util.List;

public interface TravelerService {

	public TravelerDetailResponseDto createTraveler(CreateTravelerRequestDto requestDto) ;

	public List<TravelerDetailResponseDto> findTravelersByNameOrEmail(String name, String email);

}
