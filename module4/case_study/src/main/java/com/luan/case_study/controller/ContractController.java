package com.luan.case_study.controller;

import com.luan.case_study.dto.ContractDto;
import com.luan.case_study.model.contract.Contract;
import com.luan.case_study.model.contract.ContractDetail;
import com.luan.case_study.model.customer.Customer;
import com.luan.case_study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    private IContractDetailService contractDetailService;


    @GetMapping("/customer-using-service")
    public String listCustomerUsingService(Model model,@PageableDefault(value = 5)Pageable pageable){
        model.addAttribute("customerUsingServiceList",contractService.findAllCustomerUsingService(pageable));
        return "contract/customer-using-service";
    }

    @GetMapping("")
    public String showListContract(Model model,
                                   @PageableDefault(value = 4) Pageable pageable,
                                   @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        Page<ContractDto> contractDtoPage = this.contractService.getAllContract(keywordVal, pageable);
        model.addAttribute("contractList", contractDtoPage);
        model.addAttribute("keywordVal", keywordVal);
        model.addAttribute("attachFacility", attachFacilityService.findAll());
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("attachFacility", attachFacilityService.findAll());
        model.addAttribute("listCustomer", customerService.findAll());
        model.addAttribute("listEmployee", employeeService.findAll());
        model.addAttribute("listFacility", facilityService.findAll());
        return "contract/create";
    }

    @PostMapping("/create")
    public String showCreateDetail(Contract contract, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg","Thêm mới hợp đồng thành công!");
        contractService.save(contract);
        return "redirect:/contract/";
    }
    @PostMapping("/createContractDetail")
    public String createContractDetail(@ModelAttribute ContractDetail contractDetail){
        contractDetailService.save(contractDetail);
        return "redirect:/contract/";
    }
}
