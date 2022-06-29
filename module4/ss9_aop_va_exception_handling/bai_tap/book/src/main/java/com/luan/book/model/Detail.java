package com.luan.book.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "int default 0")
    private int status;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public Detail() {
    }

    public Detail(Book book) {
        this.book = book;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
