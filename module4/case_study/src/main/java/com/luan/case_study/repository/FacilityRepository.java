package com.luan.case_study.repository;

import com.luan.case_study.model.facility.Facility;
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
public interface FacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility where `name` like :keyword and `status` = 0", nativeQuery = true,
            countQuery = "select count(*) from (select * from facility where `name` like :keyword and `status` = 0) dich_vu")
    Page<Facility> findAllByName(@Param("keyword") String keywordVal, Pageable pageable);

    @Modifying
    @Query(value = "update facility set status = 1 where id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);

    @Query(value = "select * from facility where id = :id", nativeQuery = true)
    Facility findById(@Param("id") int id );
}
