package com.controller;

import com.model.Medical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {
    @GetMapping("/home")
    public String showFormMedical(Model model) {
        model.addAttribute("medical", new Medical());
        return "medical-form";
    }

    @PostMapping("/home")
    public String saveMedical(@ModelAttribute Medical medical, Model model) {
        model.addAttribute("medicalResult", medical);
        return "medical-form";
    }
}
