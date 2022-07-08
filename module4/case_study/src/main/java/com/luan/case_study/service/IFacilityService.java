package com.luan.case_study.service;

import com.luan.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();

    Facility save(Facility facility);

    void delete(int id);

    Facility findById(int id);

    Page<Facility> findAllByName(String keywordVal, Pageable pageable);
}
