package com.luan.case_study.repository;

import com.luan.case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from contract where `start_date` like :keyword and `status` = 0", nativeQuery = true,
            countQuery = "select count(*) from (select * from contract where `start_date` like :keyword and `status` = 0) hop_dong")
    Page<Contract> findAllByName(@Param("keyword") String keywordVal, Pageable pageable);
}
