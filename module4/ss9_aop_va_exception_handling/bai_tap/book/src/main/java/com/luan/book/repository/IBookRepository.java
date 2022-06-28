package com.luan.book.repository;

import com.luan.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select * from book.book where status = 0", nativeQuery = true)
    List<Book> findAll();

    @Query(value = "select * from book b where b.id = :id", nativeQuery = true)
    Book selectById(@Param("id") int id);

    @Query(value = "select * from book.book b where b.id = :id and status = 1", nativeQuery = true)
    void updateBook(@Param("id") int id);
}
