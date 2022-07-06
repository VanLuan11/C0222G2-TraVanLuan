package com.luan.case_study.service;

import com.luan.case_study.model.contract.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    Contract findById(int id);
}
