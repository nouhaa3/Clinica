package com.example.cabinet.service.impliments;


import com.example.cabinet.persistance.entities.Consultation;
import com.example.cabinet.persistance.dao.ConsultationRepository;
import com.example.cabinet.service.impliments.ConsultationService;
import com.example.cabinet.service.interfaces.IConsultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService implements IConsultation {

    @Autowired
    private ConsultationRepository consultationRepository;

    public long count() {
        return consultationRepository.count();
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    @Override
    public Consultation getConsultationById(Long id) {
        return consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation not found with id: " + id));
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Consultation updateConsultation(Long id, Consultation consultation) {
        Consultation existingConsultation = getConsultationById(id);
        existingConsultation.setDatecons(consultation.getDatecons());
        existingConsultation.setRecapcons(consultation.getRecapcons());
        return consultationRepository.save(existingConsultation);
    }

    @Override
    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }
}