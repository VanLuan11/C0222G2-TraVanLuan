package com.luan.blog.controller;

import com.luan.blog.model.Blog;
import com.luan.blog.model.Category;
import com.luan.blog.service.IBlogService;
import com.luan.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/blogRest")
@RestController
@CrossOrigin
public class BlogRestfulController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/listBlog")
    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value = 2) Pageable pageable) {
        Page<Blog> blogPage = this.blogService.findAll(pageable);

        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> showCategory() {
        List<Category> categoryList = this.categoryService.getAllCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> showCategoryDetail(@PathVariable int id) {
        Blog blog = this.blogService.getBlog(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("{id}/id")
    public ResponseEntity<List<Blog>> showCategoryDetailId(@PathVariable int id) {
        List<Blog> blog = this.blogService.findAllCategoryId(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
