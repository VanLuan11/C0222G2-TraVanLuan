package com.lohang.luan.service;

import com.lohang.luan.model.LoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ILoHangService {
    Page<LoHang> findAll(Pageable pageable);

    void save(LoHang consignment);

    void delete(Integer id);

    LoHang findById(Integer id);
}
