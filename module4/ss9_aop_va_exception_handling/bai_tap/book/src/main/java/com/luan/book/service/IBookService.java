package com.luan.book.service;

import com.luan.book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book selectById(int id);

    void borrowBook(int id);

    List<Book> returnAll();

    void returnBook(int id);
}
