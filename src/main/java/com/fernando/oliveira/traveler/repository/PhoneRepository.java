package com.fernando.oliveira.traveler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando.oliveira.traveler.domain.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
