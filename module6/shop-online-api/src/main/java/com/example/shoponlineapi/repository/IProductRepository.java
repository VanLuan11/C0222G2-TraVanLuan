package com.example.shoponlineapi.repository;

import com.example.shoponlineapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Integer, Product> {
}
