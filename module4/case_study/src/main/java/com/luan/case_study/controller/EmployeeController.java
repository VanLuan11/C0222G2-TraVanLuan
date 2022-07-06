package com.luan.case_study.controller;

import com.luan.case_study.model.customer.Customer;
import com.luan.case_study.model.employee.Employee;
import com.luan.case_study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IDivisionService divisionService;

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("listEmployee",employeeService.findAll());
        return "employee/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("listPosition",positionService.findAll());
        model.addAttribute("listEducationDegreeService",educationDegreeService.findAll());
        model.addAttribute("listDivisionService",divisionService.findAll());
        return "employee/create";
    }
//
//    @PostMapping("/create")
//    public String getCreate(Customer customer){
//        customerService.save(customer);
//        return "redirect:/customer/";
//    }
//
    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("employee",employeeService.findById(id));
        model.addAttribute("listPosition",positionService.findAll());
        model.addAttribute("listEducationDegreeService",educationDegreeService.findAll());
        model.addAttribute("listDivisionService",divisionService.findAll());
        return "employee/edit";
    }
//
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
