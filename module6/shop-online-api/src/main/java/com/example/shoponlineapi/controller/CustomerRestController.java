package com.example.shoponlineapi.controller;

import com.example.shoponlineapi.dto.CustomerDTO;
import com.example.shoponlineapi.model.Customer;
import com.example.shoponlineapi.model.Product;
import com.example.shoponlineapi.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/customer/{userName}")
    public ResponseEntity<Customer> getCustomerByUserName(@PathVariable String userName) {
        Customer customer = iCustomerService.getCustomerByUserName(userName);
        if (userName == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/edit-customer")
    public ResponseEntity<?> editCustomer(@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setCustomerList(this.iCustomerService.findAll());
        customerDTO1.validate(customerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.hasFieldErrors(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
