package com.service;

import com.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void create(Product product);

    void edit(int idProduct, Product product);

    void delete(int idProduct);

    Product findBy(int id);

    List<Product> searchProduct(String nameProduct);
}
