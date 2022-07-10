package com.luan.case_study.service;

import com.luan.case_study.dto.CustomerUsingServiceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerUsingService {
    Page<CustomerUsingServiceDto> findAllCustomerUsingService(Pageable pageable);
}
