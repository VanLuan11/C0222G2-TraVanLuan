package com.luan.book.repository;

import com.luan.book.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetailRepository extends JpaRepository<Detail, Integer> {
}
