package com.luan.bai_thi.repository;


import com.luan.bai_thi.model.HopDong;
import com.luan.bai_thi.model.PhongTro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HopDongRepository extends JpaRepository<HopDong, Integer> {


//    @Modifying
//    @Query(value = "update hopdong set status = 1 where id = :id", nativeQuery = true)
//    void deleteById(@Param("id") int id);
//
//    @Query(value = "select * from student where id = :id", nativeQuery = true)
//    HopDong findById(@Param("id") int id);
}
