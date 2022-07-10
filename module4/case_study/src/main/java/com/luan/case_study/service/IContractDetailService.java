package com.luan.case_study.service;

import com.luan.case_study.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    ContractDetail save(ContractDetail contractDetail);
}
