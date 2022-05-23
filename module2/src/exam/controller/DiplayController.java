package exam.controller;

import exam.common.exception.Exception;
import exam.service.DienThoaiChinhHangServiceImpl;
import exam.service.DienThoaiXachTayServiceImpl;

public class DiplayController {
    static DienThoaiChinhHangServiceImpl dienThoaiChinhHangService = new DienThoaiChinhHangServiceImpl();
    static DienThoaiXachTayServiceImpl dienThoaiXachTayService = new DienThoaiXachTayServiceImpl();

    public void hienThi() {
        boolean check = true;
        do {
            System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI-----");
            System.out.println("1. Thêm mới\n" +
                    "2. Xoá\n" +
                    "3. Xem danh sách điện thoại\n" +
                    "4.Tìm kiếm \n" +
                    "5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = 0;
            choice = Exception.getInteger(choice);
            switch (choice) {
                case 1:
                    hienThiThemMoi();
                    break;
                case 2:
                    hienThiXoa();
                    break;
                case 3:
                    hienThiDanhSach();
                    break;
                case 4:
                    hienThiDienThoai();
                    break;
                default:
                    System.out.print("");
            }
        } while (check);
    }
    public void hienThiDienThoai() {
        boolean check = true;
        do {
            System.out.println("-----CHỌN LOẠI ĐIỆN THOẠI MUỐN HIỆN THỊ-----");
            System.out.println("1. Điện thoại chính hãng\n" +
                    "2. Điện thoại xách tay\n" +
                    "3. Quay lại");
            System.out.print("Chọn chức năng: ");
            int choice = 0;
            choice = Exception.getInteger(choice);
            switch (choice) {
                case 1:
                    dienThoaiChinhHangService.search();
                    break;
                case 2:
                    dienThoaiXachTayService.search();
                    break;
                case 3:
                    check = false;
                    break;
                default:
                    System.out.print("Mời chọn lại");
            }
        } while (check);
    }


    public void hienThiXoa() {
        boolean check = true;
        do {
            System.out.println("-----CHỌN LOẠI ĐIỆN THOẠI MUỐN XOÁ-----");
            System.out.println("1. Điện thoại chính hãng\n" +
                    "2. Điện thoại xách tay\n" +
                    "3. Quay lại");
            System.out.print("Chọn chức năng: ");
            int choice = 0;
            choice = Exception.getInteger(choice);
            switch (choice) {
                case 1:
                    chonXoaChinhHang();
                    break;
                case 2:
                    chonXoaXachTay();
                    break;
                case 3:
                    check = false;
                    break;
                default:
                    System.out.print("Mời chọn lại");
            }
        } while (check);
    }

    public void chonXoaChinhHang() {
        boolean check = true;
        do {
            System.out.println("-----XOÁ ĐIỆN THOẠI-----");
            System.out.println("1. Yes\n" +
                    "2. No");
            System.out.print("Chọn chức năng: ");
            int choice = 0;
            choice = Exception.getInteger(choice);
            switch (choice) {
                case 1:
                    dienThoaiChinhHangService.delete();
                    break;
                case 2:
                    check = false;
                    break;
                default:
                    System.out.print("Mời chọn lại");
            }
        } while (check);
    }

    public void chonXoaXachTay() {
        boolean check = true;
        do {
            System.out.println("-----XOÁ ĐIỆN THOẠI-----");
            System.out.println("1. Yes\n" +
                    "2. No");
            System.out.print("Chọn chức năng: ");
            int choice = 0;
            choice = Exception.getInteger(choice);
            switch (choice) {
                case 1:
                    dienThoaiXachTayService.delete();
                    break;
                case 2:
                    check = false;
                    break;
                default:
                    System.out.print("Mời chọn lại");
            }
        } while (check);
    }


    public void hienThiThemMoi() {
        boolean check = true;
        do {
            System.out.println("-----THÊM MỚI ĐIỆN THOẠI-----");
            System.out.println("1. Thêm điện thoại chính hãng\n" +
                    "2. Thêm điện thoại xách tay\n" +
                    "3. Quay lại");
            System.out.print("Chọn chức năng: ");
            int choice = 0;
            choice = Exception.getInteger(choice);
            switch (choice) {
                case 1:
                    dienThoaiChinhHangService.add();
                    break;
                case 2:
                    dienThoaiXachTayService.add();
                    break;
                case 3:
                    check = false;
                    break;
                default:
                    System.out.print("Mời chọn lại!");
            }
        } while (check);
    }

    public void hienThiDanhSach() {
        boolean check = true;
        do {
            System.out.println("-----HIỂN THỊ ĐIỆN THOẠI-----");
            System.out.println("1. Hiện thị danh sách điện thoại chính hãng\n" +
                    "2. Hiện thị danh sách điện thoại xách tay\n" +
                    "3. Quay lại");
            System.out.print("Chọn chức năng: ");
            int choice = 0;
            choice = Exception.getInteger(choice);
            switch (choice) {
                case 1:
                    dienThoaiChinhHangService.diplay();
                    break;
                case 2:
                    dienThoaiXachTayService.diplay();
                    break;
                case 3:
                    check = false;
                    break;
                default:
                    System.out.print("Mời chọn lại!");
            }
        } while (check);
    }

}
