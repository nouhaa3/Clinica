package com.example.cabinet.service.controller;

import com.example.cabinet.persistance.entities.Medecin;
import com.example.cabinet.service.impliments.MedecinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medecins")
public class MedecinController {

    private final MedecinService medecinService;

    // Constructor injection for MedecinService
    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    // Display list of all doctors
    @GetMapping
    public String listMedecins(Model model) {
        List<Medecin> medecins = medecinService.getAllMedecins();
        model.addAttribute("medecins", medecins);  // Pass the list of doctors to the view
        return "medecins";  // Return the view 'medecins.html'
    }

    // Display form to add a new doctor
    @GetMapping("/add")
    public String addMedecinForm(Model model) {
        model.addAttribute("medecin", new Medecin());  // Empty form for new doctor
        return "medecin_form";  // Return the view 'medecin_form.html'
    }

    // Save a doctor (either adding or updating)
    @PostMapping("/add")
    public String saveMedecin(@ModelAttribute Medecin medecin) {
        medecinService.saveMedecin(medecin);  // Save the doctor (add or update)
        return "redirect:/medecins";  // Redirect to the list of doctors
    }

    // Display form to edit an existing doctor
    @GetMapping("/edit/{id}")
    public String editMedecinForm(@PathVariable Long id, Model model) {
        // Handle potential error if the doctor doesn't exist
        Medecin medecin = medecinService.getMedecinById(id);
        if (medecin == null) {
            model.addAttribute("error", "Medecin not found");
            return "error";  // Display an error page if doctor is not found
        }
        model.addAttribute("medecin", medecin);  // Pass the doctor object to the form view
        return "medecin_form";  // Return the view 'medecin_form.html' for editing
    }

    // Delete a doctor by ID
    @GetMapping("/delete/{id}")
    public String deleteMedecin(@PathVariable Long id) {
        // Ensure the doctor exists before deleting
        if (medecinService.getMedecinById(id) != null) {
            medecinService.deleteMedecin(id);  // Delete the doctor if exists
        } else {
            // Optionally, add an error message if doctor doesn't exist
            return "redirect:/medecins?error=notfound";
        }
        return "redirect:/medecins";  // Redirect to the list of doctors
    }
}

