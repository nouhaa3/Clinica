package com.example.cabinet.service.impliments;


import com.example.cabinet.persistance.entities.Medecin;
import com.example.cabinet.persistance.dao.MedecinRepository;
import com.example.cabinet.service.impliments.MedecinService;
import com.example.cabinet.service.interfaces.IMedecin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedecinService implements IMedecin {

    @Autowired
    private MedecinRepository medecinRepository;
    
    public long count() {
        return medecinRepository.count();
    }

    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public Medecin getMedecinById(Long id) {
        return medecinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medecin not found with id: " + id));
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin updateMedecin(Long id, Medecin medecin) {
        Medecin existingMedecin = getMedecinById(id);
        existingMedecin.setNommedecin(medecin.getNommedecin());
        existingMedecin.setPrenommedecin(medecin.getPrenommedecin());
        existingMedecin.setAdr(medecin.getAdr());
        existingMedecin.setEmail(medecin.getEmail());
        return medecinRepository.save(existingMedecin);
    }

    @Override
    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }
}
