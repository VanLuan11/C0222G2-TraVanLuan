package com.example.shoponlineapi.service;

import com.example.shoponlineapi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProductService {

    Page<Product> findAllProduct(Pageable pageable);

    Page<Product> findAllLapTopGaming(Pageable pageable, String nameProduct, String start, String end);

    Page<Product> findAllLapTopVP(Pageable pageable, String nameProduct, String start, String end);

    void deleteProductById(Integer id);

    Product findProductById(int id);

    void save(Product product);
}
