package com.Srevice.Impl;

import com.Srevice.IProductService;
import com.model.Product;
import com.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public List<Product> getAllProduct() {
        return iProductRepository.getAllProduct();
    }

    @Override
    public void create(Product product) {
        iProductRepository.create(product);
    }

    @Override
    public Product findBy(int id) {
        return iProductRepository.findBy(id);
    }

    @Override
    public void edit(Product product) {
        iProductRepository.edit(product);
    }

    @Override
    public void delete(Integer id) {
        iProductRepository.delete(id);
    }
}
