package com.example.cabinet.persistance.dao;

import com.example.cabinet.persistance.entities.Consultation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
	long count();
}
