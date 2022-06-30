package com.luan.blog.controller;

import com.luan.blog.model.Blog;
import com.luan.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/blogRest")
@RestController
public class BlogRestfulController {
    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "/listBlog")
    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value = 2) Pageable pageable){
        Page<Blog> blogPage= this.blogService.findAll(pageable);

        if(!blogPage.hasContent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }
}
