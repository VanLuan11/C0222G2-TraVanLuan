package com.controller;

import com.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    private ICaculatorService iCaculatorService;

    @GetMapping("/home")
    public String showCaculator() {
        return "caculator-form";
    }

    @PostMapping("/caculator-form")
    public String getCaculator(@RequestParam int num1, int num2,
                               String operator, Model model) {
        Integer result = iCaculatorService.caculator(num1, num2, operator);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        return "caculator-form";
    }

}
