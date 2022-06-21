package com.model;

import org.hibernate.annotations.GenericGenerators;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String color;
    private Integer price;
    private Integer describe;

    public Product() {
    }

    public Product(Integer id, String name, String color, Integer price, Integer describe) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.describe = describe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDescribe() {
        return describe;
    }

    public void setDescribe(Integer describe) {
        this.describe = describe;
    }
}
