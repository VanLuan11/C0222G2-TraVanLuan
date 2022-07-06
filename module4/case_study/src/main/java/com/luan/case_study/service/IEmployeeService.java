package com.luan.case_study.service;

import com.luan.case_study.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Employee findById(int id);
}
