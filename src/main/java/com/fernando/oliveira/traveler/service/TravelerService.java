package com.fernando.oliveira.traveler.service;

import java.util.List;

import com.fernando.oliveira.traveler.domain.request.TravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;

public interface TravelerService {
	
	public TravelerDetailResponse createTraveler(TravelerRequest request);
	
	public TravelerDetailResponse updateTraveler(TravelerRequest request);
	
	public TravelerDetailResponse updateStatusTraveler(TravelerRequest request);
	
	public List<TravelerDetailResponse> findAllOrderByName();

	public TravelerDetailResponse getById(Long id); 
}
