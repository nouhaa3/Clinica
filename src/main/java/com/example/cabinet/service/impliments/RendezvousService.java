package com.example.cabinet.service.impliments;

import com.example.cabinet.persistance.entities.Rendezvous;
import com.example.cabinet.persistance.dao.RendezvousRepository;
import com.example.cabinet.service.impliments.RendezvousService;
import com.example.cabinet.service.interfaces.IRendezvous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendezvousService implements IRendezvous {

    @Autowired
    private RendezvousRepository rendezvousRepository;
    
    public long count() {
        return rendezvousRepository.count();
    }

    @Override
    public List<Rendezvous> getAllRendezvous() {
        return rendezvousRepository.findAll();
    }

    @Override
    public Rendezvous getRendezvousById(Long id) {
        return rendezvousRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rendezvous not found with id: " + id));
    }

    @Override
    public Rendezvous saveRendezvous(Rendezvous rendezvous) {
        return rendezvousRepository.save(rendezvous);
    }

    @Override
    public Rendezvous updateRendezvous(Long id, Rendezvous rendezvous) {
        Rendezvous existingRendezvous = getRendezvousById(id);
        existingRendezvous.setDaterdv(rendezvous.getDaterdv());
        existingRendezvous.setHeurerdv(rendezvous.getHeurerdv());
        return rendezvousRepository.save(existingRendezvous);
    }

    @Override
    public void deleteRendezvous(Long id) {
        rendezvousRepository.deleteById(id);
    }
}
