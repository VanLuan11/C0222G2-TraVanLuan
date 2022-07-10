package com.luan.case_study.service;

import com.luan.case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    Contract findById(int id);

    Page<Contract> findAllByName(String keywordVal, Pageable pageable);

    Contract save(Contract contract);
}
