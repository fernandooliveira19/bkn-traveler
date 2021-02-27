package com.fernando.oliveira.traveler;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.fernando.oliveira.traveler.domain.entity.Traveler;
import com.fernando.oliveira.traveler.domain.mapper.TravelerMapper;
import com.fernando.oliveira.traveler.domain.mother.TravelerMother;
import com.fernando.oliveira.traveler.domain.request.TravelerRequest;
import com.fernando.oliveira.traveler.domain.response.TravelerDetailResponse;
import com.fernando.oliveira.traveler.repository.TravelerRepository;
import com.fernando.oliveira.traveler.service.TravelerService;
import com.fernando.oliveira.traveler.service.impl.PhoneServiceImpl;

public class TravelerServiceTest {
	
	@InjectMocks
	TravelerService travelerService;
	
	@Mock
	TravelerRepository travelerRepository;
	
	@Mock
	private PhoneServiceImpl phoneService;
	
	@Mock
	private TravelerMapper travelerMapper;
	
	@Test
	public void shouldCreateTravelerAndReturnTravelerDetails() {
		
		TravelerRequest request = TravelerMother.getCreateTravelerRequest();
		Traveler travelerToSave = TravelerMother.getTravelerToSave();
		Traveler travelerSaved = TravelerMother.getTravelerSaved();
		TravelerDetailResponse response = TravelerMother.getCreateTravelerResponse();
		
		Mockito.when(travelerMapper.requestToEntity(request)).thenReturn(travelerToSave);
		Mockito.when(travelerRepository.save(travelerToSave)).thenReturn(travelerSaved);
		
		TravelerDetailResponse result = travelerService.createTraveler(request);
		
		Assertions.assertEquals(response.getId(), result.getId());
		Assertions.assertEquals(response.getTravelerName(), result.getTravelerName());
		Assertions.assertEquals(response.getTravelerEmail(), result.getTravelerEmail());
		
		Assertions.assertEquals(response.getIdPhone(), result.getIdPhone());
		Assertions.assertEquals(response.getPrefixPhone(), result.getPrefixPhone());
		Assertions.assertEquals(response.getNumberPhone(), result.getNumberPhone());
		
	}
	
	@Test
	public void shouldUpdateTravelerAndReturnTravelerDetails() {
		
		TravelerRequest request = TravelerMother.getUpdateTravelerRequest();
		Traveler travelerToUpdate = TravelerMother.getTravelerToUpdate();
		Traveler travelerUpdated = TravelerMother.getTravelerUpdated();
		TravelerDetailResponse response = TravelerMother.getUpdateTravelerResponse();
		
		Mockito.when(travelerMapper.requestToEntity(request)).thenReturn(travelerToUpdate);
		Mockito.when(travelerRepository.save(travelerToUpdate)).thenReturn(travelerUpdated);
		
		TravelerDetailResponse result = travelerService.updateTraveler(request);
		
		Assertions.assertEquals(response.getId(), result.getId());
		Assertions.assertEquals(response.getTravelerName(), result.getTravelerName());
		Assertions.assertEquals(response.getTravelerEmail(), result.getTravelerEmail());
		
		Assertions.assertEquals(response.getIdPhone(), result.getIdPhone());
		Assertions.assertEquals(response.getPrefixPhone(), result.getPrefixPhone());
		Assertions.assertEquals(response.getNumberPhone(), result.getNumberPhone());
		
	}
	
	@Test
	public void shouldReturnTravelerById() {
		
		Optional<Traveler> response = TravelerMother.getOptionalTravelerResponse();
		TravelerDetailResponse detailResponse = TravelerMother.getUpdateTravelerResponse();
		Long travelerId = (long) 1;
		
		Mockito.when(travelerRepository.findById(travelerId)).thenReturn(response);
		Mockito.when(travelerMapper.entityToResponse(Mockito.any())).thenReturn(detailResponse);
		
		TravelerDetailResponse result = travelerService.getById(travelerId);
		
		Assertions.assertEquals(response.get().getId(), result.getId());
		Assertions.assertEquals(response.get().getName(), result.getTravelerName());
		Assertions.assertEquals(response.get().getEmail(), result.getTravelerEmail());
		
		Assertions.assertEquals(response.get().getPhone().getId(), result.getIdPhone());
		Assertions.assertEquals(response.get().getPhone().getPrefix(), result.getPrefixPhone());
		Assertions.assertEquals(response.get().getPhone().getNumber(), result.getNumberPhone());
		
	}
	
	@Test
	public void shouldUpdateStatusTraveler() {
		
		TravelerRequest request = TravelerMother.getUpdateTravelerRequest();
		Traveler travelerToUpdate = TravelerMother.getTravelerToUpdate();
		Traveler travelerUpdated = TravelerMother.getTravelerUpdated();
		TravelerDetailResponse response = TravelerMother.getUpdateTravelerResponse();
		
		Mockito.when(travelerMapper.requestToEntity(request)).thenReturn(travelerToUpdate);
		Mockito.when(travelerRepository.save(travelerToUpdate)).thenReturn(travelerUpdated);
		
		TravelerDetailResponse result = travelerService.updateTraveler(request);
		
		Assertions.assertEquals(response.getId(), result.getId());
		Assertions.assertEquals(response.getTravelerName(), result.getTravelerName());
		Assertions.assertEquals(response.getTravelerEmail(), result.getTravelerEmail());
		
		Assertions.assertEquals(response.getIdPhone(), result.getIdPhone());
		Assertions.assertEquals(response.getPrefixPhone(), result.getPrefixPhone());
		Assertions.assertEquals(response.getNumberPhone(), result.getNumberPhone());
		
	}

}
