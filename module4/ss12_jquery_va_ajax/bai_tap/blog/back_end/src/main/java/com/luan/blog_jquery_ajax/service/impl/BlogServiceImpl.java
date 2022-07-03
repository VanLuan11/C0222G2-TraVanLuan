package com.luan.blog_jquery_ajax.service.impl;


import com.luan.blog_jquery_ajax.model.Blog;
import com.luan.blog_jquery_ajax.repository.IBlogRepository;
import com.luan.blog_jquery_ajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findAllCategoryId(Integer id) {
        return blogRepository.findAllCategoryId(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog getBlog(Integer id) {
        return blogRepository.getBlog(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByName(String keword, Pageable pageable) {
        return blogRepository.findAllByName("%" + keword + "%", pageable);
    }
}
