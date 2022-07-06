package com.luan.case_study.service.impl;

import com.luan.case_study.model.employee.Division;
import com.luan.case_study.repository.DivisionRepository;
import com.luan.case_study.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDivisionServiceImpl implements IDivisionService {
    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
