package com.luan.case_study.service.impl;

import com.luan.case_study.model.facility.Facility;
import com.luan.case_study.repository.FacilityRepository;
import com.luan.case_study.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFacilityServiceImpl implements IFacilityService {
    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility save(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public void deleteById(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public Page<Facility> findAllByName(String keywordVal, Pageable pageable) {
        return facilityRepository.findAllByName("%" + keywordVal + "%", pageable);

    }
}
