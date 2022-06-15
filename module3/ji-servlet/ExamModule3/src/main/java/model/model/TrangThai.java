package model.model;

public class TrangThai {
    private Integer idTrangThai;
    private String trangThai;
    private Integer status;

    public TrangThai() {
    }

    public TrangThai(Integer idTrangThai, String trangThai, Integer status) {
        this.idTrangThai = idTrangThai;
        this.trangThai = trangThai;
        this.status = status;
    }

    public TrangThai(Integer idTrangThai, String trangThai) {
        this.idTrangThai = idTrangThai;
        this.trangThai = trangThai;
    }

    public Integer getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(Integer idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
