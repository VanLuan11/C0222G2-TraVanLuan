package exam.model;

public abstract class DienThoai {
    private static final String COMMA = ",";
    private Integer id;
    private String tenDienThoai;
    private Integer giaBan;
    private Integer soLuong;
    private String nhaSanXuat;

    public DienThoai() {
    }

    public DienThoai(Integer id, String tenDienThoai, Integer giaBan, Integer soLuong, String nhaSanXuat) {
        this.id = id;
        this.tenDienThoai = tenDienThoai;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }
    public Integer getId() {
        return id;
}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public Integer getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Integer giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return "DienThoai: " +
                " id: " + id +
                ", tenDienThoai: " + tenDienThoai  +
                ", giaBan: " + giaBan +
                ", soLuong: " + soLuong +
                ", nhaSanXuat: " + nhaSanXuat;
    }

    public String convertLine() {
        return this.id + COMMA + this.tenDienThoai + COMMA + this.giaBan + COMMA + this.soLuong + COMMA + this.nhaSanXuat;
    }
}
