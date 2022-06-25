package com.luan.porduct_validation.service;

import com.luan.porduct_validation.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product getProduct(int id);

    void delete(int id);
}
