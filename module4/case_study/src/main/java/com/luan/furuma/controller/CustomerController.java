package com.luan.furuma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/furama")
public class CustomerController {
    @GetMapping("")
    public String show(){
        return "customer";
    }
}
