package com.example.cabinet.persistance.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmedecin;  // Changed from 'id' to 'idmedecin'
    
    private String nommedecin;  // Changed from 'nom' to 'nommedecin'
    private String prenommedecin;  // Changed from 'prenom' to 'prenommedecin'
    private String adr;
    private String email;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<Rendezvous> rendezvous;

    @ManyToOne
    @JoinColumn(name = "idspec")
    public Speciality speciality;

    // Getters et Setters
    public Long getIdmedecin() {  // Changed from 'getId' to 'getIdmedecin'
        return idmedecin;
    }

    public void setIdmedecin(Long idmedecin) {  // Changed from 'setId' to 'setIdmedecin'
        this.idmedecin = idmedecin;
    }

    public String getNommedecin() {  // Changed from 'getNom' to 'getNommedecin'
        return nommedecin;
    }

    public void setNommedecin(String nommedecin) {  // Changed from 'setNom' to 'setNommedecin'
        this.nommedecin = nommedecin;
    }

    public String getPrenommedecin() {  // Changed from 'getPrenom' to 'getPrenommedecin'
        return prenommedecin;
    }

    public void setPrenommedecin(String prenommedecin) {  // Changed from 'setPrenom' to 'setPrenommedecin'
        this.prenommedecin = prenommedecin;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rendezvous> getRendezvous() {
        return rendezvous;
    }

    public void setRendezvous(List<Rendezvous> rendezvous) {
        this.rendezvous = rendezvous;
    }

    public Speciality getSpecialite() {
        return speciality;
    }

    public void setSpecialite(Speciality speciality) {
        this.speciality = speciality;
    }
}

