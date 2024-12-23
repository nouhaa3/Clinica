package com.example.cabinet.persistance.dao;

import com.example.cabinet.persistance.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	long count();
}
