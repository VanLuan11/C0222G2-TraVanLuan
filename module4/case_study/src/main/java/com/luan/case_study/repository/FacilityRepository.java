package com.luan.case_study.repository;


import com.luan.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility where `name` like :keyword and `status` = 0", nativeQuery = true,
            countQuery = "select count(*) from (select * from facility where `name` like :keyword and `status` = 0) co_so")
    Page<Facility> findAllByName(@Param("keyword") String keywordVal, Pageable pageable);
}
