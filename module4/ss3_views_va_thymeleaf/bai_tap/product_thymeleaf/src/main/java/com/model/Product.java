package com.model;

public class Product {
    private Integer id;
    private String name;
    private Integer gia;
    private String trangThai;

    public Product() {
    }

    public Product(Integer id, String name, Integer gia, String trangThai) {
        this.id = id;
        this.name = name;
        this.gia = gia;
        this.trangThai = trangThai;
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
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gia=" + gia +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
