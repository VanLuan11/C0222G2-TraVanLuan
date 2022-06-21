package com.model;

public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private String status;

    public Product() {
    }

    public Product(Integer id, String name, Integer gia, String trangThai) {
        this.id = id;
        this.name = name;
        this.price = gia;
        this.status = trangThai;
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

    public Integer getGia() {
        return price;
    }

    public void setGia(Integer price) {
        this.price = price;
    }

    public String getTrangThai() {
        return status;
    }

    public void setTrangThai(String trangThai) {
        this.status = trangThai;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gia=" + price +
                ", trangThai='" + status + '\'' +
                '}';
    }
}
