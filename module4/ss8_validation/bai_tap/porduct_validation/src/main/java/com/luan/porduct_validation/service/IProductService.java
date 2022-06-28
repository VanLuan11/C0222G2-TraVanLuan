package com.luan.porduct_validation.service;

import com.luan.porduct_validation.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product getProduct(int id);

    void delete(int id);

    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByName(String keyword, Pageable pageable);
}
