package com.luan.case_study.service.impl;

import com.luan.case_study.model.customer.CustomerType;
import com.luan.case_study.repository.CustomerTypeRepository;
import com.luan.case_study.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
