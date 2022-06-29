package com.luan.book.service;

import com.luan.book.model.Book;
import com.luan.book.model.Detail;

import java.util.List;

public interface IDetailService {
    List<Detail> findAllById(int id);

    List<Detail> findAll();

    void create(Detail book);
}
