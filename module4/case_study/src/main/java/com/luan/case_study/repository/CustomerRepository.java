package com.luan.case_study.repository;

import com.luan.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where `name` like :keyword and `status` = 0", nativeQuery = true,
            countQuery = "select count(*) from (select * from customer where `name` like :keyword and `status` = 0) khach_hang")
    Page<Customer> findAllByName(@Param("keyword") String keywordVal, Pageable pageable);


    @Modifying
    @Query(value = "update customer set status = 1 where id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);

    @Query(value = "select * from customer where id = :id", nativeQuery = true)
    Customer findById(@Param("id") int id);

}
