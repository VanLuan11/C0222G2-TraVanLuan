package com.luan.case_study.controller;

import com.luan.case_study.model.contract.Contract;
import com.luan.case_study.model.contract.ContractDetail;
import com.luan.case_study.model.customer.Customer;
import com.luan.case_study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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

    @Autowired
    private IAttachFacilityService attachFacilityService;


    @GetMapping("")
    public String show(Model model,
                       @PageableDefault(value = 3) Pageable pageable,
                       @RequestParam(name = "keyword") Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("keywordVal", keywordVal);
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("listContract", this.contractService.findAllByName(keywordVal, pageable));
        model.addAttribute("attachFacility", attachFacilityService.findAll());
        return "contract/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", contractService.findAll());
        model.addAttribute("listCustomer", customerService.findAll());
        model.addAttribute("listEmployee", employeeService.findAll());
        model.addAttribute("listFacility", facilityService.findAll());
        return "contract/create";
    }

    @PostMapping("/create")
    public String showCreateDetail(Contract contract) {
        contractService.save(contract);
        return "redirect:/contract/";
    }

}
