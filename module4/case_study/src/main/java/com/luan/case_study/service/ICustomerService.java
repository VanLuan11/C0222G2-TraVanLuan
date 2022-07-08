package com.luan.case_study.service;

import com.luan.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer save(Customer customer);

    Customer findById(int id);

    Page<Customer> findAllByName(String keywordVal, Pageable pageable);

    void deleteById(int id);
}
