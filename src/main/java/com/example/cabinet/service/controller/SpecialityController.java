package com.example.cabinet.service.controller;

import com.example.cabinet.persistance.entities.Speciality;
import com.example.cabinet.service.impliments.SpecialityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/specialites")
public class SpecialityController {

    private final SpecialityService specialityService;

    // Constructeur
    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    // Afficher la liste des spécialités
    @GetMapping
    public String listSpecialites(Model model) {
        List<Speciality> specialites = specialityService.getAllSpecialites();
        model.addAttribute("specialites", specialites);  // Passer les spécialités à la vue
        return "specialites";  // Retourner la vue specialites.html
    }

    // Formulaire pour ajouter une spécialité
    @GetMapping("/add")
    public String addSpecialiteForm(Model model) {
        model.addAttribute("specialite", new Speciality());  // Formulaire vide
        return "specialite_form";  // Retourner la vue specialite_form.html
    }

    // Sauvegarder une spécialité (ajout ou modification)
    @PostMapping("/add")
    public String saveSpecialite(@ModelAttribute Speciality specialite) {
        specialityService.saveSpecialite(specialite);  // Sauvegarder la spécialité
        return "redirect:/specialites";  // Rediriger vers la liste des spécialités
    }

    // Formulaire de modification d'une spécialité
    @GetMapping("/edit/{id}")
    public String editSpecialiteForm(@PathVariable Long id, Model model) {
        Speciality specialite = specialityService.getSpecialiteById(id);  // Récupérer la spécialité par ID
        model.addAttribute("specialite", specialite);  // Passer la spécialité à la vue
        return "specialite_form";  // Retourner la vue specialite_form.html
    }

    // Supprimer une spécialité
    @GetMapping("/delete/{id}")
    public String deleteSpecialite(@PathVariable Long id) {
        specialityService.deleteSpecialite(id);  // Supprimer la spécialité
        return "redirect:/specialites";  // Rediriger vers la liste des spécialités
    }
}

