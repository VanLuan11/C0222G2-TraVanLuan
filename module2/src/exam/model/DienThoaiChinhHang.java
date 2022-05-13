package exam.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DienThoaiChinhHang extends DienThoai {
    private static final String COMMA = ",";
    private String thoiGianBaoHanh;
    private String phamViBaoHanh;

    public DienThoaiChinhHang() {
    }

    public DienThoaiChinhHang(String thoiGianBaoHanh, String phamViBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public DienThoaiChinhHang(Integer id, String tenDienThoai, Integer giaBan, Integer soLuong, String nhaSanXuat, String thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return "DienThoaiChinhHang: " + super.toString() +
                " thoiGianBaoHanh: " + thoiGianBaoHanh +
                ", phamViBaoHanh: " + phamViBaoHanh;
    }

    public String convertLine() {
        return super.convertLine() + COMMA + this.thoiGianBaoHanh + COMMA + this.phamViBaoHanh;
    }
}
