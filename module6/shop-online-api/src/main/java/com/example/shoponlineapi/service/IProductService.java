package com.example.shoponlineapi.service;

import com.example.shoponlineapi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Page<Product> findAllProduct(Pageable pageable);

    List<Product> findAllLaptopGaming();

    List<Product> findAllLaptopVanPhong();

    Optional<Product> findProductById(int id);
}
