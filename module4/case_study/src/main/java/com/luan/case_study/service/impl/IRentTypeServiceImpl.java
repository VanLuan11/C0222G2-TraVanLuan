package com.luan.case_study.service.impl;

import com.luan.case_study.model.facility.RentType;
import com.luan.case_study.repository.RentTypeRepository;
import com.luan.case_study.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
