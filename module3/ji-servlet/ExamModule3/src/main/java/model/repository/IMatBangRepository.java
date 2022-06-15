package model.repository;

import model.model.LoaiMatBang;
import model.model.MatBang;
import model.model.TrangThai;

import java.util.List;

public interface IMatBangRepository {
    List<MatBang> getAllMatBang();
    List<LoaiMatBang> getAllLoaiMatBang();
    List<TrangThai> getAllTrangThai();
    void delete(String maMaBang);
    List<MatBang> sreachMatBang(int searchLoaiMatBang, double searchGiaTien, int searchTang);
}
