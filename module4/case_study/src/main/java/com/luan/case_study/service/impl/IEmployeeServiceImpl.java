package com.luan.case_study.service.impl;


import com.luan.case_study.model.employee.Employee;
import com.luan.case_study.repository.EmplyoeeRepository;
import com.luan.case_study.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmplyoeeRepository emplyoeeRepository;
    @Override
    public List<Employee> findAll() {
        return emplyoeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return emplyoeeRepository.findById(id).orElse(null);
    }
}
