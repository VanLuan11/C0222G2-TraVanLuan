package model.repository.Impl;

import connection.DataBase;
import model.model.LoaiMatBang;
import model.model.MatBang;
import model.model.TrangThai;
import model.repository.IMatBangRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepositoryImpl implements IMatBangRepository {
    private static DataBase dataBase = new DataBase();
    private static final String SELECT_ALL_MAT_BANG = "select *  from mat_bang where `status` = 0 ;";
    private static final String SELECT_ALL_LOAI_MAT_BANG = "select *  from loai_mat_bang where `status` = 0 ;";
    private static final String SELECT_ALL_TRANG_THAI = "select *  from `trang_thai` where `status` = 0 ;";
    private static final String DELETE = "update mat_bang set `status`= 1 where ma_mat_bang = ?";
    private static final String FIND_MAT_BANG = "select * from mat_bang where id_loai_mat_bang like ? or gia_cho_thue like ? or tang like ? and `status` = 0;";

    @Override
    public List<MatBang> getAllMatBang() {
        List<MatBang> matBangList = new ArrayList<>();
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MAT_BANG);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String idMaBang = resultSet.getString("ma_mat_bang");
                Double dienTich = Double.valueOf(resultSet.getString("dien_tich"));
                Integer idTrangThai = Integer.valueOf(resultSet.getString("id_trang_thai"));
                Integer tang = Integer.valueOf(resultSet.getString("tang"));
                Integer idLoaiMatBang = Integer.valueOf(resultSet.getString("id_loai_mat_bang"));
                String moTaChiTiet = resultSet.getString("mo_ta_chi_tiet");
                Double giaChoThue = Double.valueOf(resultSet.getString("gia_cho_thue"));
                String ngayBatDau = resultSet.getString("ngay_bat_dau");
                String ngayKetThuc = resultSet.getString("ngay_ket_thuc");
                matBangList.add(new MatBang(idMaBang,dienTich,idTrangThai,tang,idLoaiMatBang,moTaChiTiet,giaChoThue,ngayBatDau,ngayKetThuc));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return matBangList;
    }

    @Override
    public List<LoaiMatBang> getAllLoaiMatBang() {
        List<LoaiMatBang> loaiMatBangList = new ArrayList<>();
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_LOAI_MAT_BANG);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer idLoaiMatBang = resultSet.getInt("id_loai_mat_bang");
                String loai = resultSet.getString("loai");
                loaiMatBangList.add(new LoaiMatBang(idLoaiMatBang,loai));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return loaiMatBangList;
    }

    @Override
    public List<TrangThai> getAllTrangThai() {
        List<TrangThai> trangThaiList = new ArrayList<>();
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_TRANG_THAI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer idTrangThai = resultSet.getInt("id_trang_thai");
                String trangThai = resultSet.getString("trang_thai");
                trangThaiList.add(new TrangThai(idTrangThai,trangThai));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return trangThaiList;
    }

    @Override
    public void delete(String maMaBang) {
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1, maMaBang);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<MatBang> sreachMatBang(int searchLoaiMatBang, double searchGiaTien, int searchTang) {
        List<MatBang> matBangList = new ArrayList<>();
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_MAT_BANG);
            preparedStatement.setInt(1,  searchLoaiMatBang  );
            preparedStatement.setDouble(2, searchGiaTien);
            preparedStatement.setInt(3, searchTang);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String idMaBang = resultSet.getString("ma_mat_bang");
                Double dienTich = Double.valueOf(resultSet.getString("dien_tich"));
                Integer idTrangThai = Integer.valueOf(resultSet.getString("id_trang_thai"));
                Integer tang = Integer.valueOf(resultSet.getString("tang"));
                Integer idLoaiMatBang = Integer.valueOf(resultSet.getString("id_loai_mat_bang"));
                String moTaChiTiet = resultSet.getString("mo_ta_chi_tiet");
                Double giaChoThue = Double.valueOf(resultSet.getString("gia_cho_thue"));
                String ngayBatDau = resultSet.getString("ngay_bat_dau");
                String ngayKetThuc = resultSet.getString("ngay_ket_thuc");
                matBangList.add(new MatBang(idMaBang,dienTich,idTrangThai,tang,idLoaiMatBang,moTaChiTiet,giaChoThue,ngayBatDau,ngayKetThuc));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBangList;
    }
}
