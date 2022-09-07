package com.example.shoponlineapi.service.impl;

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
    public List<Product> findAllLaptopGaming() {
        return productRepository.findAllLaptopGaming();
    }

    @Override
    public List<Product> findAllLaptopVanPhong() {
        return productRepository.findAllLaptopVanPhong();
    }

}
