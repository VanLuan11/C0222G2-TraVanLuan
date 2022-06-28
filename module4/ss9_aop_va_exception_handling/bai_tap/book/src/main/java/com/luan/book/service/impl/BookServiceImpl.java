package com.luan.book.service.impl;

import com.luan.book.model.Book;
import com.luan.book.repository.IBookRepository;
import com.luan.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book selectById(int id) {
        return bookRepository.selectById(id);
    }

    @Override
    public void updateBook(int id) {
        bookRepository.updateBook(id);
    }
}
