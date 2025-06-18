package com.mehmetkaradana.website.controller;

import com.mehmetkaradana.website.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        List<Project> projects = Arrays.asList(
            new Project(
                "TSK PERTEM Mobile App",
                "Mobile app for Turkish Armed Forces personnel with Firebase integration.",
                "Kotlin, Firebase, Android",
                "https://github.com/MehmetKARADANA/TSK_PERSONEL_TEMIN"
            ),
            new Project(
                "Game of Secret",
                "Kotlin-based game app with random truth/dare prompts built using Jetpack Compose.",
                "Kotlin, Jetpack Compose, Android",
                "https://github.com/MehmetKARADANA/GAME_OF_SECRET"
            ),
            new Project(
                "TÜBİTAK 2209-A Project",
                "NLP & ML-based research on misinformation detection using Twitter data.",
                "Python, ML, NLP",
                "https://github.com/MehmetKARADANA/sample-nlp"
            )
        );
        
        model.addAttribute("projects", projects);
        return "index";
    }
} 