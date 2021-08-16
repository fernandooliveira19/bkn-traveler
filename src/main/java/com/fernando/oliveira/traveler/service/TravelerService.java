package com.fernando.oliveira.traveler.service;

import com.fernando.oliveira.traveler.domain.entity.Traveler;

import java.util.List;
import java.util.Optional;


public interface TravelerService {

	Traveler createTraveler(Traveler traveler) ;

	List<Traveler> findTravelersByNameOrEmail(String name, String email);

	Traveler findById(Long id);

	List<Traveler> findAll();

    Traveler updateTraveler(Long id, Traveler traveler);

	List<Traveler> findByNameContainingOrderByNameAsc(String name);

	void inactivateTraveler(Long id);

	List<Traveler> findActiveTravelers();
}
