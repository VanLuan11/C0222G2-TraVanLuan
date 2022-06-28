package com.luan.book.controller;

import com.luan.book.service.IBookService;
import com.luan.book.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IDetailService detailService;

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("book", bookService.findAll());
        return "home";
    }
    @GetMapping("/detail")
   public String showDetail(@RequestParam int id, Model model){
        model.addAttribute("bookId",bookService.selectById(id));
        return "detail";
    }
    @GetMapping("/borrow")
    public String borrow(@RequestParam int id, Model model){
        bookService.updateBook(id);
        model.addAttribute("book", bookService.findAll());
        return "home";
    }

    @ExceptionHandler(Exception.class)
    public String borrowErrorPage(){
        return "error";
    }
}
