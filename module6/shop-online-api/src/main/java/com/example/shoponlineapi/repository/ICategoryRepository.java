package com.example.shoponlineapi.repository;


import com.example.shoponlineapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
