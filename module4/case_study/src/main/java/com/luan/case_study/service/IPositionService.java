package com.luan.case_study.service;

import com.luan.case_study.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
