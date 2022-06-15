package model.model;

public class LoaiMatBang {
    private Integer idLoaiMatBang;
    private String loai;
    private Integer status;

    public LoaiMatBang() {
    }

    public LoaiMatBang(Integer idLoaiMatBang, String loai, Integer status) {
        this.idLoaiMatBang = idLoaiMatBang;
        this.loai = loai;
        this.status = status;
    }

    public LoaiMatBang(Integer idLoaiMatBang, String loai) {
        this.idLoaiMatBang = idLoaiMatBang;
        this.loai = loai;
    }

    public Integer getIdLoaiMatBang() {
        return idLoaiMatBang;
    }

    public void setIdLoaiMatBang(Integer idLoaiMatBang) {
        this.idLoaiMatBang = idLoaiMatBang;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
