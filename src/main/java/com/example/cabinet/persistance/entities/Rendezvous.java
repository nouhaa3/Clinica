package com.example.cabinet.persistance.entities;

import jakarta.persistence.*;

@Entity
public class Rendezvous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrdv;
    private String daterdv;
    private String heurerdv;

    @ManyToOne
    @JoinColumn(name = "idpatient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "idmedecin")
    private Medecin medecin;

    @OneToOne(mappedBy = "rendezvous", cascade = CascadeType.ALL)
    private Consultation consultation;

    // Getters et Setters
    public Long getIdrdv() {
        return idrdv;
    }

    public void setIdrdv(Long idrdv) {
        this.idrdv = idrdv;
    }

    public String getDaterdv() {
        return daterdv;
    }

    public void setDaterdv(String daterdv) {
        this.daterdv = daterdv;
    }

    public String getHeurerdv() {
        return heurerdv;
    }

    public void setHeurerdv(String heurerdv) {
        this.heurerdv = heurerdv;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
