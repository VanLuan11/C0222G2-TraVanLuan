package com.luan.bai_thi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class HopDong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hop_dong")
    private Integer id;
    private String maHopDong;
    private String tenNguoiThue;
    private Integer cmnd;
    @Column(columnDefinition = "DATE")
    private String ngayLamHopDong;
    private String thoiGianThue;
    private Double tongTien;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_phong",referencedColumnName = "id_phong")
    private PhongTro phongTro;

    public HopDong() {
    }

    public HopDong(Integer id, String maHopDong, String tenNguoiThue, Integer cmnd, String ngayLamHopDong, String thoiGianThue, Double tongTien, PhongTro phongTro) {
        this.id = id;
        this.maHopDong = maHopDong;
        this.tenNguoiThue = tenNguoiThue;
        this.cmnd = cmnd;
        this.ngayLamHopDong = ngayLamHopDong;
        this.thoiGianThue = thoiGianThue;
        this.tongTien = tongTien;
        this.phongTro = phongTro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getTenNguoiThue() {
        return tenNguoiThue;
    }

    public void setTenNguoiThue(String tenNguoiThue) {
        this.tenNguoiThue = tenNguoiThue;
    }

    public Integer getCmnd() {
        return cmnd;
    }

    public void setCmnd(Integer cmnd) {
        this.cmnd = cmnd;
    }

    public String getNgayLamHopDong() {
        return ngayLamHopDong;
    }

    public void setNgayLamHopDong(String ngayLamHopDong) {
        this.ngayLamHopDong = ngayLamHopDong;
    }

    public String getThoiGianThue() {
        return thoiGianThue;
    }

    public void setThoiGianThue(String thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public PhongTro getPhongTro() {
        return phongTro;
    }

    public void setPhongTro(PhongTro phongTro) {
        this.phongTro = phongTro;
    }
}
