package com.luan.case_study.controller;

import com.luan.case_study.service.ICustomerUsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customerUsingService")
public class CustomerUsingServiceController {

    @Autowired
    private ICustomerUsingService customerUsingService;

    @GetMapping("")
    public String show(Model model, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("customerUsingService", customerUsingService.findAllCustomerUsingService(pageable));
        return "customer-using-service";

    }

}
