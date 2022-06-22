package com.Service;

import com.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();

    void create(Product product);

    Product findBy(int id);

    void edit(Product product);

    void delete(Integer id);
}
