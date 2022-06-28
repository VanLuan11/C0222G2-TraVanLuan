package com.luan.book.repository;

import com.luan.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select * from book b where b.status = 0", nativeQuery = true)
    List<Book> findAll();

    @Query(value = "select * from book b where b.status = 1", nativeQuery = true)
    List<Book> returnAll();

    @Query(value = "select * from book b where b.id = :id", nativeQuery = true)
    Book selectById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update book b set b.status = 1 where b.id = :id", nativeQuery = true)
    void borrowBook(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update book b set b.status = 0 where b.id = :id", nativeQuery = true)
    void returnBook(@Param("id") int id);
}
