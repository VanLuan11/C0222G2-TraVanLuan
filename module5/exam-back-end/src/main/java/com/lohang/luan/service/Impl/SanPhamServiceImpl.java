package com.lohang.luan.service.Impl;

import com.lohang.luan.model.SanPham;
import com.lohang.luan.repository.ISanPhamRepository;
import com.lohang.luan.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements ISanPhamService {
    @Autowired
    private ISanPhamRepository sanPhamRepository;
    @Override
    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }
}
