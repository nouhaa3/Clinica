package com.example.cabinet.service.controller;


import com.example.cabinet.persistance.entities.Patient;
import com.example.cabinet.service.impliments.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Afficher la liste des patients
    @GetMapping
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients";
    }

    // Formulaire pour ajouter un patient
    @GetMapping("/add")
    public String addPatientForm(Model model) {
        model.addAttribute("patient", new Patient());  // Créer un patient vide
        return "patient_form";  // Retourner la vue patient_form.html
    }

    // Sauvegarder un patient
    @PostMapping("/add")
    public String savePatient(@ModelAttribute Patient patient) {
        patientService.save(patient);  // Sauvegarder le patient
        return "redirect:/patients";  // Rediriger vers la liste des patients
    }

    // Formulaire de modification d'un patient
    @GetMapping("/edit/{id}")
    public String editPatientForm(@PathVariable Long id, Model model) {
        model.addAttribute("patient", patientService.findById(id));  // Récupérer le patient
        return "patient_form";  // Retourner la vue patient_form.html
    }

    // Sauvegarder les modifications d'un patient
    @PostMapping("/edit/{id}")
    public String updatePatient(@PathVariable Long id, @ModelAttribute Patient patient) {
        patientService.updatePatient(id, patient);  // Mettre à jour le patient
        return "redirect:/patients";  // Rediriger vers la liste des patients
    }

    // Supprimer un patient
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deleteById(id);
        return "redirect:/patients";
    }
}
