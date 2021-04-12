package com.fernando.oliveira.traveler.repository;

import com.fernando.oliveira.traveler.domain.entity.Traveler;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelerRepository extends MongoRepository<Traveler, String> {

    List<Traveler> findByNameOrEmail(String name, String email);
}
