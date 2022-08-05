package com.lohang.luan.model;

import javax.persistence.*;

@Entity
public class LoHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String maLoHang;
    private int soLuong;

    @Column(name = "ngay_nhap", columnDefinition = "DATE")
    private String ngayNhap;

    @Column(name = "ngay_san_Xuat", columnDefinition = "DATE")
    private String ngaySanXuat;

    @Column(name = "ngay_het_han", columnDefinition = "DATE")
    private String ngayHetHan;

    @ManyToOne
    @JoinColumn(name = "id_san_pham", referencedColumnName = "id")
    private SanPham sanPham ;

    public LoHang() {
    }

    public LoHang(int id, String maLoHang, int soLuong, String ngayNhap, String ngaySanXuat, String ngayHetHan, SanPham sanPham) {
        this.id = id;
        this.maLoHang = maLoHang;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.sanPham = sanPham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaLoHang() {
        return maLoHang;
    }

    public void setMaLoHang(String maLoHang) {
        this.maLoHang = maLoHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}
