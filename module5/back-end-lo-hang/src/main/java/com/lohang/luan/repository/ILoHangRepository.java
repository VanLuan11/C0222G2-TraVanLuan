package com.lohang.luan.repository;

import com.lohang.luan.model.LoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoHangRepository extends JpaRepository<LoHang, Integer> {

}
