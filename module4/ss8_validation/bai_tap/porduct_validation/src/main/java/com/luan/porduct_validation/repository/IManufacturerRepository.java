package com.luan.porduct_validation.repository;

import com.luan.porduct_validation.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
    @Query(value = "select * from manufacturer", nativeQuery = true)
    List<Manufacturer> findAll();
}
