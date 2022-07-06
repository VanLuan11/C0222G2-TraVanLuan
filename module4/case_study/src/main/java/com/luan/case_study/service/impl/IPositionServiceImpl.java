package com.luan.case_study.service.impl;

import com.luan.case_study.model.employee.Position;
import com.luan.case_study.repository.PositionRepository;
import com.luan.case_study.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPositionServiceImpl implements IPositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
