package com.luan.blog.service.impl;

import com.luan.blog.model.Category;
import com.luan.blog.repository.ICategoryRepository;
import com.luan.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.getAllCategory();
    }
}
