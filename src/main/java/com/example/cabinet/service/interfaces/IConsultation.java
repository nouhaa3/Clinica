package com.example.cabinet.service.interfaces;

import com.example.cabinet.persistance.entities.Consultation;

import java.util.List;

public interface IConsultation {
    List<Consultation> getAllConsultations();
    Consultation getConsultationById(Long id);
    Consultation saveConsultation(Consultation consultation);
    Consultation updateConsultation(Long id, Consultation consultation);
    void deleteConsultation(Long id);
}