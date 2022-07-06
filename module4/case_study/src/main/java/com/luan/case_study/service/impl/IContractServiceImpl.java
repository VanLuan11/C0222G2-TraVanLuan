package com.luan.case_study.service.impl;

import com.luan.case_study.model.contract.Contract;
import com.luan.case_study.repository.ContractRepository;
import com.luan.case_study.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IContractServiceImpl implements IContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).orElse(null);
    }
}
