package com.luan.porduct_validation.repository;

import com.luan.porduct_validation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product", nativeQuery = true)
    List<Product> findAll();

    @Query(value = "select * from product p where p.id = :id", nativeQuery = true)
    Product getProduct(@Param("id") int id);
}
