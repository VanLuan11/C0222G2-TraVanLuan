package com.luan.case_study.service.impl;

import com.luan.case_study.model.contract.ContractDetail;
import com.luan.case_study.repository.ContractDetailRepository;
import com.luan.case_study.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail save(ContractDetail contractDetail) {
        return contractDetailRepository.save(contractDetail);
    }
}
