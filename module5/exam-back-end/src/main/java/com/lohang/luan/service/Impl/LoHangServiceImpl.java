package com.lohang.luan.service.Impl;

import com.lohang.luan.model.LoHang;
import com.lohang.luan.repository.ILoHangRepository;
import com.lohang.luan.service.ILoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoHangServiceImpl implements ILoHangService {
    @Autowired
    private ILoHangRepository loHangRepository;

    @Override
    public Page<LoHang> findAll(Pageable pageable, String productName, String dateCheckOut, String startDate, String endDate) {
        return loHangRepository.findAll(pageable, "%" + productName + "%", "%" + dateCheckOut + "%", startDate, endDate);
    }

    @Override
    public void save(LoHang consignment) {
        this.loHangRepository.save(consignment);
    }

    @Override
    public void delete(Integer id) {
        this.loHangRepository.delete(this.loHangRepository.getById(id));
    }

    @Override
    public LoHang findById(Integer id) {
        return this.loHangRepository.findById(id).orElse(null);
    }


}
