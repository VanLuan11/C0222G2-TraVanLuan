package com.luan.case_study.repository;

import com.luan.case_study.dto.CustomerUsingServiceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerUsingServiceRepository extends JpaRepository<CustomerUsingServiceDto, Integer> {
    @Query(value = "select c.id, c.name, c.phone, c.address, c.email, f.name, af.name, c.status from customer c" +
            "join contract ct on ct.customer_id = c.id" +
            "join facility f on ct.facility_id = f.id" +
            "join contract_detail cdt on cdt. contract_id = ct.id" +
            "join attach_facility af on af.id = cdt.attach_facility_id", nativeQuery = true)
    Page<CustomerUsingServiceDto> findAllCustomerUsingService(Pageable pageable);


}
