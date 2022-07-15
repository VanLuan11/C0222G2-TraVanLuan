package com.luan.bai_thi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class PhongTro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phong")
    private Integer id;
    private String maPhong;

    private Double dienTich;
    private Double gia;
    private int tinhTrang;

    @OneToOne(mappedBy = "phongTro")
    private HopDong hopDong;

    public PhongTro() {
    }

    public PhongTro(Integer id, String maPhong, Double dienTich, Double gia, int tinhTrang, HopDong hopDong) {
        this.id = id;
        this.maPhong = maPhong;
        this.dienTich = dienTich;
        this.gia = gia;
        this.tinhTrang = tinhTrang;
        this.hopDong = hopDong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public Double getDienTich() {
        return dienTich;
    }

    public void setDienTich(Double dienTich) {
        this.dienTich = dienTich;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public HopDong getHopDong() {
        return hopDong;
    }

    public void setHopDong(HopDong hopDong) {
        this.hopDong = hopDong;
    }
}
