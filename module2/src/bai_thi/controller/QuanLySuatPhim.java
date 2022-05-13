package bai_thi.controller;

import bai_thi.common.Exception;
import bai_thi.service.QuanLySuatPhimImpl;


public class QuanLySuatPhim {
    QuanLySuatPhimImpl quanLySuatPhim = new QuanLySuatPhimImpl();

    public void diplaySuatPhim() {
        boolean check = true;
        do {
            System.out.println("Hệ thống quản lý suất chiếu phim");
            System.out.println(" 1. Danh sách toàn bộ suất chiếu của rạp.\n" +
                    " 2. Thêm mới một suất chiếu\n" +
                    " 3. Xoá suất chiếu bất kì theo Mã suất chiếu\n" +
                    " 4. Sắp Xếp theo vé\n " +
                    " 5. Chỉnh sửa\n" +
                    " 6. Tìm kiếm\n" +
                    " 7.Thoát");
            System.out.print("Chọn chức năng: ");
            Integer choice = 0;
            choice = Exception.exception(choice);
            switch (choice) {
                case 1:
                    quanLySuatPhim.diplayy();
                    break;
                case 2:
                    quanLySuatPhim.add();
                    break;
                case 3:
                    diplayDelete();
                    break;
                case 4:
                    quanLySuatPhim.sort();
                    break;
                case 5:
                    quanLySuatPhim.edit();
                    break;
                case 6:
                    quanLySuatPhim.search();
                    break;
                case 7:
                    System.out.println("CÚT!!!!!");
                    check = false;
                    break;
                default:
                    System.out.println("CÓ NHẬP CŨNG NGU!!!");
                    break;
            }
        } while (check);
    }

    public void diplayDelete() {
        boolean check = true;
        do {
            System.out.println("1.yes\n" +
                    "2.no\n" +
                    "3.quay lại");
            System.out.print("Chọn chức năng: ");
            Integer choice = 0;
            choice = Exception.exception(choice);
            switch (choice) {
                case 1:
                    quanLySuatPhim.detele();
                    break;
                case 2:
                    System.out.println("bạn đã ko xoá!");
                    break;
                default:
                    check = false;
                    break;
            }
        } while (check);
    }


}

