package com.example.shoponlineapi.repository;

import com.example.shoponlineapi.model.OrderService;
import com.example.shoponlineapi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = " select * from product where is_deleted = 0 ", nativeQuery = true,
            countQuery = " select count(*) from (select * from product where is_deleted = 0  ) productPage")
    Page<Product> findAllProduct(Pageable pageable);

    @Query(value = " select * from product where is_deleted = 0 and id = :id ", nativeQuery = true)
    Product findProductById(int id);

    @Query(value = " select * from product where is_deleted = 0 and category_id = 1 and `name` like :nameProduct and (price between :start and :end ) ", nativeQuery = true,
            countQuery = " select count(*) from (select * from product where is_deleted = 0 and category_id = 1 and `name` like :nameProduct and (price between :start and :end ) ) gaming")
    Page<Product> findAllLapTopGaming(Pageable pageable, String nameProduct, String start, String end);

    @Query(value = " select * from product where is_deleted = 0 and category_id = 2 and `name` like :nameProduct and (price between :start and :end ) ", nativeQuery = true,
            countQuery = " select count(*) from (select * from product where is_deleted = 0 and category_id = 2 and `name` like :nameProduct and (price between :start and :end ) ) vp")
    Page<Product> findAllLapTopVP(Pageable pageable, String nameProduct, String start, String end);

    @Transactional
    @Modifying
    @Query(value = " update product set is_deleted = 1 where id = :id ", nativeQuery = true)
    void deleteProductById(Integer id);

    @Modifying
    @Transactional
    @Query(value = " UPDATE `product` SET `quantity` = (`quantity` - :quantity) WHERE (`id` = :id) ", nativeQuery = true)
    void updateQuantity(@Param("quantity") Integer quantity,@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = " UPDATE `product` SET `is_deleted` = 1 WHERE (`id` = :id) ", nativeQuery = true)
    void updateIsDeleted(@Param("id") Integer id);

}
