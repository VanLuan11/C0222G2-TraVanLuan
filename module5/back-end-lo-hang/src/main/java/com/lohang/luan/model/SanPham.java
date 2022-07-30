package com.lohang.luan.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenSanPham;
    private String xuatXu;
    private int giaTien;
    private String doVi;

    @JsonBackReference
    @OneToMany(mappedBy = "sanPham")
    private List<LoHang> loHangList;

    public SanPham() {
    }

    public SanPham(int id, String tenSanPham, String xuatXu, int giaTien, String doVi, List<LoHang> loHangList) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.xuatXu = xuatXu;
        this.giaTien = giaTien;
        this.doVi = doVi;
        this.loHangList = loHangList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getDoVi() {
        return doVi;
    }

    public void setDoVi(String doVi) {
        this.doVi = doVi;
    }

    public List<LoHang> getLoHangList() {
        return loHangList;
    }

    public void setLoHangList(List<LoHang> loHangList) {
        this.loHangList = loHangList;
    }
}
