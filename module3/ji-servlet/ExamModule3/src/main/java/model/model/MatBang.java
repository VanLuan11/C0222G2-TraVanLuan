package model.model;

public class MatBang {
    private String maMaBang;
    private Double dienTich;
    private Integer idTrangThai;
    private Integer tang;
    private Integer idLoaiMatBang;
    private String moTaChiTiet;
    private Double giaChoThue;
    private String ngayBatDau;
    private String ngayKetThuc;
    private Integer status;

    public MatBang() {
    }

    public MatBang(String maMaBang, Double dienTich, Integer idTrangThai, Integer tang, Integer idLoaiMatBang, String moTaChiTiet, Double giaChoThue, String ngayBatDau, String ngayKetThuc, Integer status) {
        this.maMaBang = maMaBang;
        this.dienTich = dienTich;
        this.idTrangThai = idTrangThai;
        this.tang = tang;
        this.idLoaiMatBang = idLoaiMatBang;
        this.moTaChiTiet = moTaChiTiet;
        this.giaChoThue = giaChoThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.status = status;
    }

    public MatBang(String maMaBang, Double dienTich, Integer idTrangThai, Integer tang, Integer idLoaiMatBang, String moTaChiTiet, Double giaChoThue, String ngayBatDau, String ngayKetThuc) {
        this.maMaBang = maMaBang;
        this.dienTich = dienTich;
        this.idTrangThai = idTrangThai;
        this.tang = tang;
        this.idLoaiMatBang = idLoaiMatBang;
        this.moTaChiTiet = moTaChiTiet;
        this.giaChoThue = giaChoThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaMaBang() {
        return maMaBang;
    }

    public void setMaMaBang(String maMaBang) {
        this.maMaBang = maMaBang;
    }

    public Double getDienTich() {
        return dienTich;
    }

    public void setDienTich(Double dienTich) {
        this.dienTich = dienTich;
    }

    public Integer getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(Integer idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public Integer getTang() {
        return tang;
    }

    public void setTang(Integer tang) {
        this.tang = tang;
    }

    public Integer getIdLoaiMatBang() {
        return idLoaiMatBang;
    }

    public void setIdLoaiMatBang(Integer idLoaiMatBang) {
        this.idLoaiMatBang = idLoaiMatBang;
    }

    public String getMoTaChiTiet() {
        return moTaChiTiet;
    }

    public void setMoTaChiTiet(String moTaChiTiet) {
        this.moTaChiTiet = moTaChiTiet;
    }

    public Double getGiaChoThue() {
        return giaChoThue;
    }

    public void setGiaChoThue(Double giaChoThue) {
        this.giaChoThue = giaChoThue;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
