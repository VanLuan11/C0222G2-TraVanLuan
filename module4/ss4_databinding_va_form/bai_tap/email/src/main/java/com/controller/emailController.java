package com.controller;

import com.model.Email;
import com.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/home")
public class emailController {
    @GetMapping("/email")
    public String showEmail(ModelMap modelMap) {
        modelMap.addAttribute("email", new Email());
        return "email-form";
    }

    @PostMapping("/email")
    public String getEmail(@ModelAttribute Email email, ModelMap modelMap) {
        modelMap.addAttribute("email", email);
        return "email-form";
    }
}
