package com.luan.book.repository;

import com.luan.book.model.Book;
import com.luan.book.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetailRepository extends JpaRepository<Detail, Integer> {
    @Query(value = "select * from detail where id = :id",nativeQuery = true)
    List<Detail> findAllById(@Param("id") int id);

    @Query(value = "select * from detail ",nativeQuery = true)
    List<Detail> findAll();

}
