package com.fernando.oliveira.traveler.repository;

import com.fernando.oliveira.traveler.domain.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long> {

    List<Traveler> findByNameOrEmail(String name, String email);

    List<Traveler> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
}
