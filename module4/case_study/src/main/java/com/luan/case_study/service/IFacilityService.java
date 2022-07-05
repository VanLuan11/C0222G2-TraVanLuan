package com.luan.case_study.service;

import com.luan.case_study.model.facility.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();

    Facility save(Facility facility);
}
