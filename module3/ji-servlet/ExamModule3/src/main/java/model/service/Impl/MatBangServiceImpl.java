package model.service.Impl;

import model.model.LoaiMatBang;
import model.model.MatBang;
import model.model.TrangThai;
import model.repository.IMatBangRepository;
import model.repository.Impl.MatBangRepositoryImpl;
import model.service.IMatBangService;

import java.util.List;

public class MatBangServiceImpl implements IMatBangService {
    private static IMatBangRepository iMatBangRepository = new MatBangRepositoryImpl();
    @Override
    public List<MatBang> getAllMatBang() {
        return iMatBangRepository.getAllMatBang();
    }

    @Override
    public List<LoaiMatBang> getAllLoaiMatBang() {
        return iMatBangRepository.getAllLoaiMatBang();
    }

    @Override
    public List<TrangThai> getAllTrangThai() {
        return iMatBangRepository.getAllTrangThai();
    }

    @Override
    public void delete(String maMaBang) {
        iMatBangRepository.delete(maMaBang);
    }

    @Override
    public List<MatBang> sreachMatBang(int searchLoaiMatBang, double searchGiaTien, int searchTang) {
        return iMatBangRepository.sreachMatBang(searchLoaiMatBang, searchGiaTien, searchTang);
    }
}
