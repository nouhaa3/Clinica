package com.example.cabinet.persistance.entities;

import jakarta.persistence.*;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcons;
    public String datecons;
    public String recapcons;

    @OneToOne
    @JoinColumn(name = "idrdv")
    public Rendezvous rendezvous;

    // Getters et Setters
    public Long getIdcons() {
        return idcons;
    }

    public void setIdcons(Long idcons) {
        this.idcons = idcons;
    }

    public String getDatecons() {
        return datecons;
    }

    public void setDatecons(String datecons) {
        this.datecons = datecons;
    }

    public String getRecapcons() {
        return recapcons;
    }

    public void setRecapcons(String recapcons) {
        this.recapcons = recapcons;
    }

    public Rendezvous getRendezvous() {
        return rendezvous;
    }

    public void setRendezvous(Rendezvous rendezvous) {
        this.rendezvous = rendezvous;
    }
}
