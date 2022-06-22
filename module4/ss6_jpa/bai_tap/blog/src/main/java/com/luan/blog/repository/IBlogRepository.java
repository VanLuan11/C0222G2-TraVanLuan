package com.luan.blog.repository;

import com.luan.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = " select * " +
            " from blog ", nativeQuery = true)
    List<Blog> findAll();
}
