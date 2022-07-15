package com.luan.bai_thi.service;

import com.luan.bai_thi.model.HopDong;

import java.util.List;

public interface IHopDongService {
    List<HopDong> findAll();

    HopDong save(HopDong hopDong);

    void deleteById(int id);
}
