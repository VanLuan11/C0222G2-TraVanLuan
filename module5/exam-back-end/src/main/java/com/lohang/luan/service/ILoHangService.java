package com.lohang.luan.service;

import com.lohang.luan.model.LoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;


public interface ILoHangService {
    Page<LoHang> findAll(Pageable pageable, String productName, String dateCheckOut, String startDate, String endDate);

    void save(LoHang consignment);

    void delete(Integer id);

    LoHang findById(Integer id);

}
