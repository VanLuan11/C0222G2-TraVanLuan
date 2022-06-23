package com.luan.blog.service;

import com.luan.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void delete(Integer id);
    void update(Blog blog);
    Blog getBlog(Integer id);
}
