package com.example.cabinet.service.interfaces;

import com.example.cabinet.persistance.entities.Patient;

import java.util.List;

public interface IPatient {
    List<Patient> getAllPatients();
    Patient findById(Long id);
    Patient save(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    void deleteById(Long id);
}

