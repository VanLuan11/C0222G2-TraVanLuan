package com.luan.blog_jquery_ajax.controller;


import com.luan.blog_jquery_ajax.model.Blog;
import com.luan.blog_jquery_ajax.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/blogRest")
@RestController
@CrossOrigin
public class BlogRestfulController {
    @Autowired
    private IBlogService blogService;

//    @GetMapping("/list")
//    public ResponseEntity<Page<Blog>> showAllBlog(@PageableDefault(value = 5) Pageable pageable,
//                                                  @RequestParam(name = "keyword") Optional<String> keyword) {
//        String keywordVal = keyword.orElse("");
//        Page<Blog> blogPage = this.blogService.findAllByName(keywordVal,pageable);
//        if (!blogPage.hasContent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseE  ntity<>(blogPage,HttpStatus.OK);
//    }

    @PostMapping("/create")
    public ResponseEntity<Blog> createSmartphone(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog),HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> getPageBlog(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam Optional<String> searchValue){
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        String searchParam = searchValue.orElse("");
        Page<Blog> blogs = this.blogService.findAllByName(searchParam ,pageable);
        if (blogs.hasContent()) {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
