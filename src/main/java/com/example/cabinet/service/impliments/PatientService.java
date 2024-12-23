package com.example.cabinet.service.impliments;

import com.example.cabinet.persistance.entities.Patient;
import com.example.cabinet.persistance.dao.PatientRepository;
import com.example.cabinet.service.impliments.PatientService;
import com.example.cabinet.service.interfaces.IPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatient {

    @Autowired
    private PatientRepository patientRepository;

    public long count() {
        return patientRepository.count();
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = findById(id);
        existingPatient.setNompatient(patient.getNompatient());
        existingPatient.setPrenompatient(patient.getPrenompatient());
        existingPatient.setAdrpatient(patient.getAdrpatient());
        existingPatient.setEmailpatient(patient.getEmailpatient());
        return patientRepository.save(existingPatient);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}
