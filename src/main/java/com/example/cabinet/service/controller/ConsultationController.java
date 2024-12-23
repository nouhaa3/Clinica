package com.example.cabinet.service.controller;

import com.example.cabinet.persistance.entities.Consultation;
import com.example.cabinet.service.impliments.ConsultationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultations")
public class ConsultationController {

    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    // Afficher la liste des consultations
    @GetMapping
    public String listConsultations(Model model) {
        List<Consultation> consultations = consultationService.getAllConsultations();
        model.addAttribute("consultations", consultations);  // Passer les consultations à la vue
        return "consultations";  // Retourner la vue consultations.html
    }

    // Formulaire pour ajouter une consultation
    @GetMapping("/add")
    public String addConsultationForm(Model model) {
        model.addAttribute("consultation", new Consultation());  // Formulaire vide
        return "consultation_form";  // Retourner la vue consultation_form.html
    }

    // Sauvegarder une consultation (ajout ou modification)
    @PostMapping("/add")
    public String saveConsultation(@ModelAttribute Consultation consultation) {
        consultationService.saveConsultation(consultation);  // Sauvegarder la consultation
        return "redirect:/consultations";  // Rediriger vers la liste des consultations
    }

    // Formulaire de modification d'une consultation
    @GetMapping("/edit/{id}")
    public String editConsultationForm(@PathVariable Long id, Model model) {
        Consultation consultation = consultationService.getConsultationById(id);  // Récupérer la consultation par ID
        model.addAttribute("consultation", consultation);  // Passer la consultation à la vue
        return "consultation_form";  // Retourner la vue consultation_form.html
    }

    // Supprimer une consultation
    @GetMapping("/delete/{id}")
    public String deleteConsultation(@PathVariable Long id) {
        consultationService.deleteConsultation(id);  // Supprimer la consultation
        return "redirect:/consultations";  // Rediriger vers la liste des consultations
    }
}