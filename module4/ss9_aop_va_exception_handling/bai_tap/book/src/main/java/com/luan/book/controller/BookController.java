package com.luan.book.controller;

import com.luan.book.model.Book;
import com.luan.book.model.Detail;
import com.luan.book.service.IBookService;
import com.luan.book.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IDetailService detailService;

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("books", bookService.findAll());
        return "home";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("book", new Book());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Book book){
        for(int i =0; i<book.getQuantity(); i++){
            Detail detail = new Detail(book);
            detailService.create(detail);
        }
        return "redirect:/book";
    }

    @GetMapping("/detail")
    public String showDetail(Model model){
        model.addAttribute("detailB", detailService.findAll());
        return "detail";
    }


//    @ExceptionHandler(Exception.class)
//    public String borrowErrorPage(){
//        return "error";
//    }
}
