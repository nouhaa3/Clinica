package com.example.cabinet.service.interfaces;

import com.example.cabinet.persistance.entities.Rendezvous;

import java.util.List;

public interface IRendezvous {
    List<Rendezvous> getAllRendezvous();
    Rendezvous getRendezvousById(Long id);
    Rendezvous saveRendezvous(Rendezvous rendezvous);
    Rendezvous updateRendezvous(Long id, Rendezvous rendezvous);
    void deleteRendezvous(Long id);
}