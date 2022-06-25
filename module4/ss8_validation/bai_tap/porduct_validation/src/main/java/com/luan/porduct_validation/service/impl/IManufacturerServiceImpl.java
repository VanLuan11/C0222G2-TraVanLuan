package com.luan.porduct_validation.service.impl;

import com.luan.porduct_validation.model.Manufacturer;
import com.luan.porduct_validation.repository.IManufacturerRepository;
import com.luan.porduct_validation.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IManufacturerServiceImpl implements IManufacturerService {
    @Autowired
    private IManufacturerRepository manufacturerRepository;
    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }
}
