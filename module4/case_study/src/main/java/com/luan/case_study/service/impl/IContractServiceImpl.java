package com.luan.case_study.service.impl;

import com.luan.case_study.model.contract.Contract;
import com.luan.case_study.repository.ContractRepository;
import com.luan.case_study.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Contract> findAllByName(String keywordVal, Pageable pageable) {
        return contractRepository.findAllByName("%"+keywordVal+"%", pageable);
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }
}
