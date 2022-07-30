package com.lohang.luan.repository;

import com.lohang.luan.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISanPhamRepository extends JpaRepository<SanPham, Integer> {
}
