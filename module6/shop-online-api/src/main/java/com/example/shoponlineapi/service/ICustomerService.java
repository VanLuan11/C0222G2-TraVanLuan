package com.example.shoponlineapi.service;



import com.example.shoponlineapi.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getCustomerByUserName(String userName);

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);
}
