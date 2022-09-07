package com.example.shoponlineapi.repository;

import com.example.shoponlineapi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = " select * from product where is_deleted = 0 ", nativeQuery = true,
            countQuery = " select count(*) from ( select * from product where is_deleted = 0 ) product")
    Page<Product> findAllProduct(Pageable pageable);

    @Query(value = " select * from product where is_deleted = 0 and category_id = 1 ", nativeQuery = true)
    List<Product> findAllLaptopGaming();

    @Query(value = " select * from product where is_deleted = 0 and category_id = 2 ", nativeQuery = true)
    List<Product> findAllLaptopVanPhong();

    @Query(value = " select * from product where is_deleted = 0 and category_id = 2 ", nativeQuery = true)
    Optional<Product> findProductById(int id);
}
