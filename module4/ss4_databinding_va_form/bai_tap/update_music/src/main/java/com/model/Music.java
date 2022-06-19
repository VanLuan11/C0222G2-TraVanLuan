package com.model;

public class Music {
    private String ten;
    private String caSi;
    private String theLoai;
    private String duongDan;

    public Music() {
    }

    public Music(String ten, String caSi, String theLoai, String duongDan) {
        this.ten = ten;
        this.caSi = caSi;
        this.theLoai = theLoai;
        this.duongDan = duongDan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }
}
