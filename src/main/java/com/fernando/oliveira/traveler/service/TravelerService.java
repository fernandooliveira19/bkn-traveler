package com.fernando.oliveira.traveler.service;

import com.fernando.oliveira.traveler.domain.entity.Traveler;

import java.util.List;
import java.util.Optional;


public interface TravelerService {

	Traveler createTraveler(Traveler traveler) ;

	List<Traveler> findTravelersByNameOrEmail(String name, String email);

	Traveler findById(String id);

	List<Traveler> findAll();

    Traveler updateTraveler(String id, Traveler traveler);
}
