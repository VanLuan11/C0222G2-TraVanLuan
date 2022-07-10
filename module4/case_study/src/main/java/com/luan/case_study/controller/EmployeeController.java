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
        model.addAttribute("employee",new Employee());
        model.addAttribute("listPosition",positionService.findAll());
        model.addAttribute("listEducationDegreeService",educationDegreeService.findAll());
        model.addAttribute("listDivisionService",divisionService.findAll());
        return "employee/list";
    }

}
