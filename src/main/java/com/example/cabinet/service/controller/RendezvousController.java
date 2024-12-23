package com.example.cabinet.service.controller;

import com.example.cabinet.persistance.entities.Medecin;
import com.example.cabinet.persistance.entities.Patient;
import com.example.cabinet.persistance.entities.Rendezvous;
import com.example.cabinet.service.impliments.MedecinService;
import com.example.cabinet.service.impliments.PatientService;
import com.example.cabinet.service.impliments.RendezvousService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rendezvous")
public class RendezvousController {

    private final RendezvousService rendezvousService;
    private final PatientService patientService;
    private final MedecinService medecinService;

    // Constructor with dependencies
    public RendezvousController(RendezvousService rendezvousService, PatientService patientService, MedecinService medecinService) {
        this.rendezvousService = rendezvousService;
        this.patientService = patientService;
        this.medecinService = medecinService;
    }

    // Display the list of appointments
    @GetMapping
    public String listRendezvous(Model model) {
        List<Rendezvous> rendezvous = rendezvousService.getAllRendezvous();
        model.addAttribute("rendezvous", rendezvous);
        return "rendezvous"; // Return the rendezvous.html view
    }

    // Form to add a new appointment
    @GetMapping("/add")
    public String addRendezvousForm(Model model) {
        // Fetch the lists of patients and doctors
        List<Patient> patients = patientService.getAllPatients();
        List<Medecin> medecins = medecinService.getAllMedecins();

        // Add them to the model
        model.addAttribute("patients", patients);
        model.addAttribute("medecins", medecins);
        model.addAttribute("rendezvous", new Rendezvous()); // Empty form

        return "rendezvous_form"; // Return the rendezvous_form.html view
    }

    // Save an appointment (add or edit)
    @PostMapping("/add")
    public String saveRendezvous(@ModelAttribute Rendezvous rendezvous) {
        if (rendezvous.getIdrdv() != null) {
            Rendezvous existingRendezvous = rendezvousService.getRendezvousById(rendezvous.getIdrdv());
            if (existingRendezvous != null) {
                // Update fields of the existing rendezvous
                existingRendezvous.setDaterdv(rendezvous.getDaterdv());
                existingRendezvous.setHeurerdv(rendezvous.getHeurerdv());
                existingRendezvous.setPatient(rendezvous.getPatient());
                existingRendezvous.setMedecin(rendezvous.getMedecin());
                rendezvousService.saveRendezvous(existingRendezvous);
                return "redirect:/rendezvous";
            }
        }
        // Otherwise, save a new rendezvous
        rendezvousService.saveRendezvous(rendezvous);
        return "redirect:/rendezvous";
    }


    // Form to edit an existing appointment
    @GetMapping("/edit/{id}")
    public String editRendezvousForm(@PathVariable Long id, Model model) {
        Rendezvous rendezvous = rendezvousService.getRendezvousById(id);
        List<Patient> patients = patientService.getAllPatients();
        List<Medecin> medecins = medecinService.getAllMedecins();

        model.addAttribute("patients", patients);
        model.addAttribute("medecins", medecins);
        model.addAttribute("rendezvous", rendezvous);

        return "rendezvous_form"; // Return the rendezvous_form.html view
    }

    // Delete an appointment
    @GetMapping("/delete/{id}")
    public String deleteRendezvous(@PathVariable Long id) {
        rendezvousService.deleteRendezvous(id);
        return "redirect:/rendezvous";
    }
}

