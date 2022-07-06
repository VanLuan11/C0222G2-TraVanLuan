package com.luan.case_study.controller;

import com.luan.case_study.model.contract.Contract;
import com.luan.case_study.model.customer.Customer;
import com.luan.case_study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("listContract",contractService.findAll());
        return "contract/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("contract",new Contract());
        model.addAttribute("listCustomer",customerService.findAll());
        model.addAttribute("listEmployee",employeeService.findAll());
        model.addAttribute("listFacility",facilityService.findAll());
        return "contract/create";
    }

//
//    @PostMapping("/create")
//    public String getCreate(Customer customer){
//        customerService.save(customer);
//        return "redirect:/customer/";
//    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("contract",contractService.findById(id));
        model.addAttribute("listCustomer",customerService.findAll());
        model.addAttribute("listEmployee",employeeService.findAll());
        model.addAttribute("listFacility",facilityService.findAll());
        return "contract/edit";
    }

//    @PostMapping("/edit")
//    public String getEdit(Customer customer){
//        customerService.save(customer);
//        return "redirect:/customer/";
//    }
//    @GetMapping("{id}/delete")
//    public String showDelete(@PathVariable int id){
//        customerService.delete(id);
//        return "redirect:/customer/";
//    }
}
