package com.example.cabinet.persistance.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpatient;
    private String nompatient;
    private String prenompatient;
    private String adrpatient;
    private String emailpatient;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Rendezvous> rendezvous;

    // Getters et Setters
    public Long getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Long idpatient) {
        this.idpatient = idpatient;
    }

    public String getNompatient() {
        return nompatient;
    }

    public void setNompatient(String nompatient) {
        this.nompatient = nompatient;
    }

    public String getPrenompatient() {
        return prenompatient;
    }

    public void setPrenompatient(String prenompatient) {
        this.prenompatient = prenompatient;
    }

    public String getAdrpatient() {
        return adrpatient;
    }

    public void setAdrpatient(String adrpatient) {
        this.adrpatient = adrpatient;
    }

    public String getEmailpatient() {
        return emailpatient;
    }

    public void setEmailpatient(String emailpatient) {
        this.emailpatient = emailpatient;
    }

    public List<Rendezvous> getRendezvous() {
        return rendezvous;
    }

    public void setRendezvous(List<Rendezvous> rendezvous) {
        this.rendezvous = rendezvous;
    }

}
