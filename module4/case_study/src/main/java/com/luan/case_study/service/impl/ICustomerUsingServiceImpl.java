package com.luan.case_study.service.impl;

import com.luan.case_study.dto.CustomerUsingServiceDto;
import com.luan.case_study.repository.ICustomerUsingServiceRepository;
import com.luan.case_study.service.ICustomerUsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICustomerUsingServiceImpl  implements ICustomerUsingService {
    @Autowired
    private ICustomerUsingServiceRepository customerUsingServiceRepository;

    @Override
    public Page<CustomerUsingServiceDto> findAllCustomerUsingService(Pageable pageable) {
        return customerUsingServiceRepository.findAllCustomerUsingService(pageable);
    }


}
