package com.example.cabinet.persistance.dao;

import com.example.cabinet.persistance.entities.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezvousRepository extends JpaRepository<Rendezvous, Long> {
	long count();
}
