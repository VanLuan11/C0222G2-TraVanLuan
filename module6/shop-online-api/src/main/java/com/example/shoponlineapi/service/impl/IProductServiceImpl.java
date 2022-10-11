package com.example.shoponlineapi.service.impl;

import com.example.shoponlineapi.model.OrderService;
import com.example.shoponlineapi.model.Product;
import com.example.shoponlineapi.repository.IProductRepository;
import com.example.shoponlineapi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;


    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAllProduct(pageable);
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAllLapTopGaming(Pageable pageable, String nameProduct, String start, String end) {
        return productRepository.findAllLapTopGaming(pageable, "%" + nameProduct + "%", start, end);
    }

    @Override
    public Page<Product> findAllLapTopVP(Pageable pageable, String nameProduct, String start, String end) {
        return productRepository.findAllLapTopVP(pageable, "%" + nameProduct + "%", start, end);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }


}
