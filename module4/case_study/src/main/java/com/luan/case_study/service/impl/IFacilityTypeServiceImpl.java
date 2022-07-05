package com.luan.case_study.service.impl;

import com.luan.case_study.model.facility.FacilityType;
import com.luan.case_study.repository.FacilityTypeRepository;
import com.luan.case_study.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFacilityTypeServiceImpl implements IFacilityTypeService {
    @Autowired
    private FacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
