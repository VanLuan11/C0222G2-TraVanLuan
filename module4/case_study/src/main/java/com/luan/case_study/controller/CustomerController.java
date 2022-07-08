package com.luan.case_study.controller;

import com.luan.case_study.model.customer.Customer;
import com.luan.case_study.service.ICustomerService;
import com.luan.case_study.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String show(Model model,
                       @PageableDefault(value = 5)Pageable pageable,
                       @RequestParam(name = "keyword") Optional<String> keyword){
        String keywordVal = keyword.orElse("");
        model.addAttribute("keywordVal",keywordVal);
        model.addAttribute("listCustomer", this.customerService.findAllByName(keywordVal, pageable));
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("listCustomerType",customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/create")
    public String getCreate(Customer customer){
        customerService.save(customer);
        return "redirect:/customer/";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("listCustomer",customerService.findById(id));
        model.addAttribute("listCustomerType",customerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String getEdit(Customer customer){
        customerService.save(customer);
        return "redirect:/customer/";
    }
    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id){
        customerService.deleteById(id);
        return "redirect:/customer/";
    }
}
