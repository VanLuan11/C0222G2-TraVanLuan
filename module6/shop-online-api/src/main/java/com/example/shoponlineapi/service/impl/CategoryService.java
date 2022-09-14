package com.example.shoponlineapi.service.impl;


import com.example.shoponlineapi.model.Category;
import com.example.shoponlineapi.repository.ICategoryRepository;
import com.example.shoponlineapi.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepository.findAll();
    }
}
