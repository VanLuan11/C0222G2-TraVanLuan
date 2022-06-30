package com.luan.blog.repository;


import com.luan.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = " select *  from category ", nativeQuery = true)
    List<Category> getAllCategory();
}
