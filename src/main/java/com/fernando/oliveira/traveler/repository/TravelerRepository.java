package com.fernando.oliveira.traveler.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fernando.oliveira.traveler.domain.entity.Traveler;

@Repository
public interface TravelerRepository extends JpaRepository<Traveler, Long>{

	public Optional<Traveler> findByName(String name);

	public Page<Traveler> findByNameContainingOrderByNameAsc(String name, Pageable pageable);

	public List<Traveler> findAllByOrderByName();

	@Query("select t from traveler t where t.status='ACTIVE' order by t.name")
    public List<Traveler> findAllActiveTravelersOrderByName();
	
	public List<Traveler> findByNameContainingOrderByNameAsc(String name);
}
