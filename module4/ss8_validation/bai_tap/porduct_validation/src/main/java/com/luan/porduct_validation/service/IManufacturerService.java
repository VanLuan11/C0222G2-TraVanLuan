package com.luan.porduct_validation.service;

import com.luan.porduct_validation.model.Manufacturer;

import java.util.List;

public interface IManufacturerService {
    List<Manufacturer> findAll();
}
