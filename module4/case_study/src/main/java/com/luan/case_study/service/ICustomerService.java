package com.luan.case_study.service;

import com.luan.case_study.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer save(Customer customer);

    Customer findById(int id);

    void delete(int id);
}
