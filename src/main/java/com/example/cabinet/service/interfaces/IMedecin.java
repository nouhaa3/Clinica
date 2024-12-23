package com.example.cabinet.service.interfaces;

import com.example.cabinet.persistance.entities.Medecin;
import java.util.List;

public interface IMedecin {
    List<Medecin> getAllMedecins();
    Medecin getMedecinById(Long id);
    Medecin saveMedecin(Medecin medecin);
    Medecin updateMedecin(Long id, Medecin medecin);
    void deleteMedecin(Long id);
}