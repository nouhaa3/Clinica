package com.example.cabinet.persistance.dao;

import com.example.cabinet.persistance.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
	long count();
}

