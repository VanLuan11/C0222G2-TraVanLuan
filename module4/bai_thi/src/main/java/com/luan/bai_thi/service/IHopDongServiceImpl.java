package com.luan.bai_thi.service;

import com.luan.bai_thi.model.HopDong;
import com.luan.bai_thi.repository.HopDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IHopDongServiceImpl implements IHopDongService{
    @Autowired
    private HopDongRepository hopDongRepository;
    @Override
    public List<HopDong> findAll() {
        return hopDongRepository.findAll();
    }

    @Override
    public HopDong save(HopDong hopDong) {
        return hopDongRepository.save(hopDong);
    }

    @Override
    public void deleteById(int id) {
        hopDongRepository.deleteById(id);
    }
}
