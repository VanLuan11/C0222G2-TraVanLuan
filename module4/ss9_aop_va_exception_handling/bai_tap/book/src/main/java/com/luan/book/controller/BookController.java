package com.luan.book.controller;

import com.luan.book.service.IBookService;
import com.luan.book.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService bookService;

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
    public String borrowBook(@RequestParam int id){
        bookService.borrowBook(id);
        return "redirect:/book/";
    }

    @GetMapping("/return")
    public String showReturn( Model model){
        model.addAttribute("returnBook", bookService.returnAll());
        return "return";
    }
    @PostMapping("/return")
    public String returnBook(@RequestParam int id){
        bookService.returnBook(id);
        return "redirect:/book/";
    }

    @ExceptionHandler(Exception.class)
    public String borrowErrorPage(){
        return "error";
    }
}
