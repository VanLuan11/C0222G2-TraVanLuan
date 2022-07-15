package com.luan.bai_thi.repository;

import com.luan.bai_thi.model.PhongTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongTroRepository extends JpaRepository<PhongTro, Integer> {
}
