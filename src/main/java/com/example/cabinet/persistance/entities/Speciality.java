package com.example.cabinet.persistance.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idspec;
    public String nomspecialite;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL)
    public List<Medecin> medecins;

    // Getters et Setters
    public Long getIdspec() {
        return idspec;
    }

    public void setIdspec(Long idspec) {
        this.idspec = idspec;
    }

    public String getNomspecialite() {
        return nomspecialite;
    }

    public void setNomspecialite(String nomspecialite) {
        this.nomspecialite = nomspecialite;
    }

    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }
}
