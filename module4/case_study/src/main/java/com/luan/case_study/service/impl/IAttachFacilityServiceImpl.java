package com.luan.case_study.service.impl;

import com.luan.case_study.model.contract.AttachFacility;
import com.luan.case_study.repository.AttachFacilityRepository;
import com.luan.case_study.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAttachFacilityServiceImpl implements IAttachFacilityService {
    @Autowired
    private AttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}
