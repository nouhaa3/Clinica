package com.example.cabinet.persistance.dao;

import com.example.cabinet.persistance.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
	long count();
}
