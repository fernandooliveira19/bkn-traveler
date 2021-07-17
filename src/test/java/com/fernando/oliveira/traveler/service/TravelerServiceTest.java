package com.fernando.oliveira.traveler.service;

import com.fernando.oliveira.traveler.domain.entity.Traveler;
import com.fernando.oliveira.traveler.domain.enums.Status;
import com.fernando.oliveira.traveler.domain.mother.TravelerMother;
import com.fernando.oliveira.traveler.exception.TravelerException;
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

import static com.fernando.oliveira.traveler.domain.mother.TravelerMother.getTraveler;
import static com.fernando.oliveira.traveler.domain.mother.TravelerMother.getTravelerUpdated;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TravelerServiceTest {
	
	@InjectMocks
	private TravelerServiceImpl travelerService;

	@Mock
	TravelerRepository repository;
	

	@Test
	public void shouldCreateTravelerAndReturnTravelerDetails() {
		
		Traveler travelerToSave = getTraveler();
		Traveler travelerSaved = getTraveler();
		travelerSaved.setStatus(Status.ACTIVE.getCode());
		travelerSaved.setId(123L);
		
		when(repository.save(travelerToSave)).thenReturn(travelerSaved);

		Traveler result = travelerService.createTraveler(travelerToSave);

		assertNotNull(result.getId());
		assertEquals(travelerSaved.getId(),result.getId());
		assertEquals(travelerToSave.getName(),result.getName() );
		assertEquals(travelerToSave.getEmail(), result.getEmail() );

		assertEquals(Status.ACTIVE.getCode(), result.getStatus());
		assertEquals(travelerToSave.getPrefixPhone(), result.getPrefixPhone());
		assertEquals(travelerToSave.getNumberPhone(),result.getNumberPhone() );
		
	}

	@Test
	public void shouldReturnTravelerListByNameOrEmail(){

		Traveler traveler = getTraveler();
		List<Traveler> responseList = Arrays.asList(traveler);
		String name = "Joao da Silva";
		String email = "joao.silva@teste.com";

		when(repository.findByNameOrEmail(name, email)).thenReturn(responseList);

		List<Traveler> result = travelerService.findTravelersByNameOrEmail(name, email);

		assertFalse(result.isEmpty());

	}

	@Test
	public void shouldReturnTravelerById(){
		Long id = 1234L;
		Traveler traveler = getTraveler();
		traveler.setId(id);
		traveler.setStatus(Status.ACTIVE.getCode());


		when(repository.findById(id)).thenReturn(Optional.of(traveler));

		Traveler result = travelerService.findById(id);

		assertEquals(traveler.getId(), result.getId());
		assertEquals(traveler.getName(), result.getName());
		assertEquals(traveler.getEmail(), result.getEmail());
		assertEquals(traveler.getStatus(), result.getStatus());
		assertEquals(traveler.getDocument(), result.getDocument());
		assertEquals(traveler.getPrefixPhone(), result.getPrefixPhone());
		assertEquals(traveler.getNumberPhone(), result.getNumberPhone());

	}

	@Test
	public void shouldReturnAllTravelers(){
		Traveler traveler = getTraveler();
		traveler.setId(1234L);
		traveler.setStatus(Status.ACTIVE.getCode());

		when(repository.findAll()).thenReturn(Arrays.asList(traveler));

		List<Traveler> result = travelerService.findAll();

		assertEquals(traveler.getId(), result.get(0).getId());
		assertEquals(traveler.getName(), result.get(0).getName());
		assertEquals(traveler.getEmail(), result.get(0).getEmail());
		assertEquals(traveler.getStatus(), result.get(0).getStatus());
		assertEquals(traveler.getDocument(), result.get(0).getDocument());
		assertEquals(traveler.getPrefixPhone(), result.get(0).getPrefixPhone());
		assertEquals(traveler.getNumberPhone(), result.get(0).getNumberPhone());

	}

	@Test
	public void shouldReturnAllTravelersByNameOrEmail(){
		Traveler traveler = getTraveler();
		String name = "Fernando Augusto";
		String email = "f19@uol.com.br";
		when(repository.findByNameOrEmail(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Arrays.asList(traveler));

		List<Traveler> result = travelerService.findTravelersByNameOrEmail(name, email);

		assertEquals(traveler.getName(), result.get(0).getName());
		assertEquals(traveler.getEmail(), result.get(0).getEmail());

	}

	@Test
	public void shouldUpdateTravelerAndReturnTravelerDetails() {

		Long id = 123L;
		Traveler travelerToUpdate = getTraveler();
		travelerToUpdate.setStatus(Status.ACTIVE.getCode());
		travelerToUpdate.setId(id);

		Traveler travelerUpdated = getTravelerUpdated();


		when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(travelerToUpdate));
		when(repository.save(Mockito.any(Traveler.class))).thenReturn(travelerUpdated);

		Traveler result = travelerService.updateTraveler(id,travelerToUpdate);

		assertNotNull(result.getId());
		assertEquals(travelerUpdated.getId(),result.getId());
		assertEquals(travelerUpdated.getName(),result.getName() );
		assertEquals(travelerUpdated.getEmail(), result.getEmail() );

		assertEquals(travelerUpdated.getStatus(), result.getStatus());
		assertEquals(travelerUpdated.getPrefixPhone(), result.getPrefixPhone());
		assertEquals(travelerUpdated.getNumberPhone(),result.getNumberPhone() );

	}


	@Test
	public void shouldReturnMessageExceptionWhenTravelerNotFoundById() {

		Long id = 123L;

		when(repository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

		Exception exception = assertThrows(TravelerException.class, () ->{
			travelerService.findById(id);
		});

		assertEquals(exception.getMessage(), "Nenhum viajante encontrado pelo id: " + id);


	}



}
