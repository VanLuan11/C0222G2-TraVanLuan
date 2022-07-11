package com.luan.case_study.controller;

import com.luan.case_study.dto.CustomerDto;
import com.luan.case_study.model.customer.Customer;
import com.luan.case_study.service.ICustomerService;
import com.luan.case_study.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
                       @PageableDefault(value = 5) Pageable pageable,
                       @RequestParam(name = "keyword") Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("keywordVal", keywordVal);
        model.addAttribute("listCustomer", this.customerService.findAllByName(keywordVal, pageable));
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("listCustomerType", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/create")
    public String getCreate(@ModelAttribute @Valid CustomerDto customerDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listCustomerType", customerTypeService.findAll());
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        redirectAttributes.addFlashAttribute("msg",
                "Đã thêm mới thành công !");
        customerService.save(customer);
        return "redirect:/customer/";
    }


    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id, Model model) {
        Customer customer = this.customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("listCustomerType", customerTypeService.findAll());
        return "customer/edit";
    }


    @PostMapping("/edit")
    public String getEdit(@ModelAttribute @Validated CustomerDto customerDto,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        redirectAttributes.addFlashAttribute("msg","Chỉnh sửa thành công thành !");
        customerService.save(customer);
        return "redirect:/customer/";
    }

    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg",
                "Đã xoá thành công !");
        customerService.deleteById(id);
        return "redirect:/customer/";
    }


}
