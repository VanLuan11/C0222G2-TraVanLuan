package com.luan.book.service.impl;

import com.luan.book.model.Book;
import com.luan.book.model.Detail;
import com.luan.book.repository.IDetailRepository;
import com.luan.book.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements IDetailService {
    @Autowired
    private IDetailRepository detailRepository;

    @Override
    public List<Detail> findAllById(int id) {
        return detailRepository.findAllById(id);
    }

    @Override
    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public void create(Detail book) {
        detailRepository.save(book);
    }
}
