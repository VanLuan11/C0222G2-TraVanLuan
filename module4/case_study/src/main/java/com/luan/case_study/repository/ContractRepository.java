package com.luan.case_study.repository;

import com.luan.case_study.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository  extends JpaRepository<Contract, Integer> {
}
