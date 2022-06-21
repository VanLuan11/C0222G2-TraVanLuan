package com.repository;

import com.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();
    Product findBy(int id);
    void create(Product product);
    void edit(Product product);
    void delete(int id);
}
