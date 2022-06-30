package com.luan.blog.model;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @Column(name = "date_Start_Time", columnDefinition = "DATE")
    private String dateStartTime;
    private String note;
    private String name;
    @ManyToOne
    @JoinColumn(name = "catagory_id", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String content, String dateStartTime, String note, String name, Category category) {
        this.id = id;
        this.content = content;
        this.dateStartTime = dateStartTime;
        this.note = note;
        this.name = name;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateStartTime() {
        return dateStartTime;
    }

    public void setDateStartTime(String dateStartTime) {
        this.dateStartTime = dateStartTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
