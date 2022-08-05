package com.lohang.luan.repository;

import com.lohang.luan.model.LoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoHangRepository extends JpaRepository<LoHang, Integer> {

    @Query(value = "select lo_hang.* from lo_hang " +
            " join san_pham on san_pham.id = lo_hang.id_san_pham " +
            " where san_pham.ten_san_pham like :productName and ngay_het_han like :dateCheckOut and ( ngay_nhap between :startDate and :endDate ) ", nativeQuery = true,
    countQuery = " select count(*) from (select lo_hang.* from lo_hang " +
            " join san_pham on san_pham.id = lo_hang.id_san_pham " +
            " where san_pham.ten_san_pham like :productName and ngay_het_han like :dateCheckOut and (ngay_nhap between :startDate and :endDate ) ) temp_table " )
    Page<LoHang> findAll(Pageable pageable, @Param("productName") String productName,
                         @Param("dateCheckOut") String dateCheckOut, String startDate, String endDate);
}
