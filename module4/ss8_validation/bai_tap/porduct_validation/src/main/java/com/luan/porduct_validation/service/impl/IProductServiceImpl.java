package com.luan.porduct_validation.service.impl;

import com.luan.porduct_validation.model.Product;
import com.luan.porduct_validation.repository.IProductRepository;
import com.luan.porduct_validation.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

}
