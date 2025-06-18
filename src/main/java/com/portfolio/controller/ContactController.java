package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @PostMapping("/contact")
    public String handleContact(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message,
            Model model
    ) {
        // Burada e-posta gönderebilir veya veritabanına kaydedebilirsin.
        // Şimdilik sadece başarı mesajı gösteriyoruz.
        model.addAttribute("success", "Mesajınız başarıyla gönderildi!");
        return "index";
    }
} 