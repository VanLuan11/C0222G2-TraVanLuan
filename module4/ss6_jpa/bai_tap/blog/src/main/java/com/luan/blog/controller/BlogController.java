package com.luan.blog.controller;

import com.luan.blog.model.Blog;
import com.luan.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showBlog(Model model){
        model.addAttribute("listBlog",this.blogService.findAll());
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Blog blog, Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }
    @PostMapping("/create")
    public String getCreate(Blog blog){
        this.blogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String getEdit(Blog blog){
        this.blogService.update(blog);
        return "redirect:/blog";
    }
    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id, Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String getCDelete(Blog blog){
        this.blogService.delete(blog.getId());
        return "redirect:/blog";
    }

}
