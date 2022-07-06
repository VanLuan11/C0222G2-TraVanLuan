package com.luan.case_study.service.impl;

import com.luan.case_study.model.employee.EducationDegree;
import com.luan.case_study.repository.EducationDegreeRepository;
import com.luan.case_study.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IEducationDegreeServiceImpl implements IEducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
