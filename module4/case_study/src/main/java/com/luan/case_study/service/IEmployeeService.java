package com.luan.case_study.service;

import com.luan.case_study.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Page<Employee> findAllByName(String searchParam, Pageable pageable);
}
