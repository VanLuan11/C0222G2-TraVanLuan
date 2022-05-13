package bai_thi.model;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class SuatChieu {
    private static final String COMMA = ",";
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private String maSuatChieu;
    private String tenPhim;
    private Date date;
    private Integer soLuongVe;

    public SuatChieu() {
    }

    public SuatChieu(String maSuatChieu, String tenPhim, Date date1, Integer soLuongVe) {
        this.maSuatChieu = maSuatChieu;
        this.tenPhim = tenPhim;
        this.date = date1;
        this.soLuongVe = soLuongVe;
    }

    public String getMaSuatChieu() {
        return maSuatChieu;
    }

    public void setMaSuatChieu(String maSuatChieu) {
        this.maSuatChieu = maSuatChieu;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(Integer soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    @Override
    public String toString() {
        return "QuanLySuatChieu= " +
                " maSuatChieu: " + maSuatChieu +
                ", tenPhim: " + tenPhim +
                ", date: " + dateFormat.format(date) +
                ", soLuongVe: " + soLuongVe;
    }

    public String convertLine() {
        return this.maSuatChieu + COMMA + this.tenPhim + COMMA + dateFormat.format(this.date) + COMMA + this.soLuongVe;
    }
}
