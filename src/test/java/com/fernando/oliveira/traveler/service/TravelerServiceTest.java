package com.fernando.oliveira.traveler.service;

import com.fernando.oliveira.traveler.domain.entity.Traveler;
import com.fernando.oliveira.traveler.domain.enums.Status;
import com.fernando.oliveira.traveler.domain.mother.TravelerMother;
import com.fernando.oliveira.traveler.repository.TravelerRepository;
import com.fernando.oliveira.traveler.service.impl.TravelerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TravelerServiceTest {
	
	@InjectMocks
	TravelerServiceImpl service;

	@Mock
	TravelerRepository repository;
	

	@Test
	public void shouldCreateTravelerAndReturnTravelerDetails() {
		
		Traveler travelerToSave = TravelerMother.getTraveler();
		Traveler travelerSaved = TravelerMother.getTraveler();
		travelerSaved.setStatus("A");
		travelerSaved.setId("123");
		
		Mockito.when(repository.save(travelerToSave)).thenReturn(travelerSaved);

		Traveler result = service.createTraveler(travelerToSave);

		Assertions.assertNotNull(result.getId());
		Assertions.assertEquals(travelerSaved.getId(),result.getId());
		Assertions.assertEquals(travelerToSave.getName(),result.getName() );
		Assertions.assertEquals(travelerToSave.getEmail(), result.getEmail() );

		Assertions.assertEquals(Status.ACTIVE.getCode(), result.getStatus());
		Assertions.assertEquals(travelerToSave.getPrefixPhone(), result.getPrefixPhone());
		Assertions.assertEquals(travelerToSave.getNumberPhone(),result.getNumberPhone() );
		
	}

	@Test
	public void shouldReturnTravelerListByNameOrEmail(){

		Traveler traveler = TravelerMother.getTraveler();
		List<Traveler> responseList = Arrays.asList(traveler);
		String name = "Joao da Silva";
		String email = "joao.silva@teste.com";

		Mockito.when(repository.findByNameOrEmail(name, email)).thenReturn(responseList);

		List<Traveler> result = service.findTravelersByNameOrEmail(name, email);

		Assertions.assertFalse(result.isEmpty());

	}

	@Test
	public void shouldReturnTravelerById(){
		Traveler traveler = TravelerMother.getTraveler();
		traveler.setId("1234");
		traveler.setStatus("A");

		String id = "1234";
		Mockito.when(repository.findById(id)).thenReturn(Optional.of(traveler));

		Traveler result = service.findById(id);

		Assertions.assertEquals(traveler.getId(), result.getId());
		Assertions.assertEquals(traveler.getName(), result.getName());
		Assertions.assertEquals(traveler.getEmail(), result.getEmail());
		Assertions.assertEquals(traveler.getStatus(), result.getStatus());
		Assertions.assertEquals(traveler.getDocument(), result.getDocument());
		Assertions.assertEquals(traveler.getPrefixPhone(), result.getPrefixPhone());
		Assertions.assertEquals(traveler.getNumberPhone(), result.getNumberPhone());

	}

	@Test
	public void shouldReturnAllTravelers(){
		Traveler traveler = TravelerMother.getTraveler();
		traveler.setId("1234");
		traveler.setStatus("A");

		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(traveler));

		List<Traveler> result = service.findAll();

		Assertions.assertEquals(traveler.getId(), result.get(0).getId());
		Assertions.assertEquals(traveler.getName(), result.get(0).getName());
		Assertions.assertEquals(traveler.getEmail(), result.get(0).getEmail());
		Assertions.assertEquals(traveler.getStatus(), result.get(0).getStatus());
		Assertions.assertEquals(traveler.getDocument(), result.get(0).getDocument());
		Assertions.assertEquals(traveler.getPrefixPhone(), result.get(0).getPrefixPhone());
		Assertions.assertEquals(traveler.getNumberPhone(), result.get(0).getNumberPhone());

	}

	@Test
	public void shouldReturnAllTravelersByNameOrEmail(){
		Traveler traveler = TravelerMother.getTraveler();
		String name = "Fernando Augusto";
		String email = "f19@uol.com.br";
		Mockito.when(repository.findByNameOrEmail(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Arrays.asList(traveler));

		List<Traveler> result = service.findTravelersByNameOrEmail(name, email);

		Assertions.assertEquals(traveler.getName(), result.get(0).getName());
		Assertions.assertEquals(traveler.getEmail(), result.get(0).getEmail());

	}

}
