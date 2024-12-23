package com.example.cabinet.service.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // Ajouter des attributs au modèle si nécessaire, par exemple :
        model.addAttribute("title", "CLINICA - Votre clinique de confiance");
        model.addAttribute("message", "Bienvenue chez CLINICA. Explorez notre tableau de bord pour plus d'informations.");
        
        // Retourner le nom de la vue Thymeleaf (sans l'extension .html)
        return "home";
    }
}
