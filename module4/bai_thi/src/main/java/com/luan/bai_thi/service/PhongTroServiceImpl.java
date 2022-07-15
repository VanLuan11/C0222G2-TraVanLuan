package com.luan.bai_thi.service;

import com.luan.bai_thi.model.PhongTro;
import com.luan.bai_thi.repository.PhongTroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongTroServiceImpl implements IPhongTroService{
    @Autowired
    private PhongTroRepository phongTroRepository;
    @Override
    public List<PhongTro> findAll() {
        return phongTroRepository.findAll();
    }
}
