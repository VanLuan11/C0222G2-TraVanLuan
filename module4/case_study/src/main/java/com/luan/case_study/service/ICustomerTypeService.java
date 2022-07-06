package com.luan.case_study.service;

import com.luan.case_study.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
