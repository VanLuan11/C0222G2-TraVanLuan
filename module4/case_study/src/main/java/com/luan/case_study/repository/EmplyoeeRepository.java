package com.luan.case_study.repository;

import com.luan.case_study.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmplyoeeRepository extends JpaRepository<Employee, Integer> {
}
