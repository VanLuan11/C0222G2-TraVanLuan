package com.controller;

import com.service.ISandwichSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SandwichController {
    @Autowired
    private ISandwichSerivce iSandwichSerivce;

    @RequestMapping("/home")
    public String showSandwich() {
        return "form-sandwich";
    }

    @RequestMapping("/form-sandwich")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "form-sandwich";
    }
}
