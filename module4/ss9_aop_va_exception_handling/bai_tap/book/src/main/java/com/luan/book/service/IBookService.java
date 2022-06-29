package com.luan.book.service;

import com.luan.book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);
}
