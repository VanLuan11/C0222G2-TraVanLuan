package com.luan.case_study.service.impl;

import com.luan.case_study.model.customer.Customer;
import com.luan.case_study.repository.CustomerRepository;
import com.luan.case_study.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Page<Customer> findAllByName(String keywordVal, Pageable pageable) {
        return customerRepository.findAllByName("%" + keywordVal +"%",pageable);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }


}
