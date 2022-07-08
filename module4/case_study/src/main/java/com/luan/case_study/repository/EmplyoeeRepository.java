package com.luan.case_study.repository;

import com.luan.case_study.model.employee.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EmplyoeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where `name` like :keyword and `status` = 0", nativeQuery = true,
            countQuery = "select count(*) from (select * from employee where `name` like :keyword and `status` = 0) nhan_vien")
    Page<Employee> findAllByName(@Param("keyword") String keywordVal, Pageable pageable);
}
