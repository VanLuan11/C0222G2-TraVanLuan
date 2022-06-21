package com.repository;

import com.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();

    void create(Product product);

    Product findBy(int id);

    void edit(Product product);

    void delete(Integer id);
}
