package exam.service;

import exam.common.readandwrite.ReadAndWrite;
import exam.model.DienThoaiChinhHang;
import exam.model.DienThoaiXachTay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DienThoaiXachTayServiceImpl implements IDienThoaiXachTayService {
    static List<DienThoaiXachTay> dienThoaiXachTayArrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private static final String FILE_XACH_TAY = "exam/common/data/DienThoaiXachTay.csv";

    @Override
    public void add() {
        System.out.println("-----THÊM MỚI-----");

        System.out.print("Thêm mới Id: ");
        Integer id = Integer.parseInt(scanner.nextLine());

        System.out.print("Thêm mới tên điện thoại: ");
        String tenDienThoai = scanner.nextLine();

        System.out.print("Thêm mới giá bán: ");
        Integer giaBan = Integer.parseInt(scanner.nextLine());

        System.out.print("Thêm mới số lượng: ");
        Integer soLuong = Integer.parseInt(scanner.nextLine());

        System.out.print("Thêm mới nhà sản xuất: ");
        String nhaSanXuat = scanner.nextLine();

        System.out.print("Thêm mới quốc gia xách tay: ");
        String xachTay = scanner.nextLine();

        System.out.print("Thêm mới trạng thái: ");
        String trangThai = scanner.nextLine();
        DienThoaiXachTay dienThoaiXachTay = new DienThoaiXachTay(id, tenDienThoai, giaBan, soLuong, nhaSanXuat, xachTay, trangThai);
        dienThoaiXachTayArrayList.add(dienThoaiXachTay);
        ReadAndWrite.writeDienThoaiXachTay(FILE_XACH_TAY, dienThoaiXachTayArrayList);
    }

    @Override
    public void diplay() {
        dienThoaiXachTayArrayList = ReadAndWrite.readFileDienThoaiXachTay(FILE_XACH_TAY);
        System.out.println("-----HIỂN THỊ DANH SÁCH ĐIỆN THOẠI CHÍNH HÃNG-----");
        if (!dienThoaiXachTayArrayList.isEmpty()) {
            for (DienThoaiXachTay d : dienThoaiXachTayArrayList) {
                System.out.println(d);
            }
        } else {
            System.out.println("Danh sách rỗng!");
        }

    }

    @Override
    public void delete() {
        dienThoaiXachTayArrayList = ReadAndWrite.readFileDienThoaiXachTay(FILE_XACH_TAY);
        System.out.println("-----TÌM KIẾM MUỐN XOÁ-----");
        System.out.print("Nhập id cần xoá: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        for (int i = 0; i < dienThoaiXachTayArrayList.size(); i++) {
            if (dienThoaiXachTayArrayList.get(i).getId() == id) {
                System.out.println("Xoá thành công!");
                dienThoaiXachTayArrayList.remove(i);
                flag = false;
            }
            ReadAndWrite.writeDienThoaiXachTay(FILE_XACH_TAY, dienThoaiXachTayArrayList); 
        }
        diplay();
        if (flag) {
            System.err.println("Không tìm thấy!");
        }


    }


    @Override
    public void search() {
        dienThoaiXachTayArrayList = ReadAndWrite.readFileDienThoaiXachTay(FILE_XACH_TAY);
        System.out.println("-----TÌM KIẾM-----");
        System.out.print("nhập id muốn tìm kiếm");
        Integer id = Integer.parseInt(scanner.nextLine());
        while (!check(id)) {
            System.out.println("không tìm thấy");
            System.out.print("Nhập lại: ");
            id = Integer.parseInt(scanner.nextLine());
        }
        if (check(id)) {
            for (DienThoaiXachTay d : dienThoaiXachTayArrayList) {
                if (d.getId() == id) {
                    System.out.println(d);
                }
            }
        }

    }

    public boolean check(Integer integer) {
        for (DienThoaiXachTay d : dienThoaiXachTayArrayList) {
            if (d.getId() == integer) {
                return true;
            }
        }
        return false;
    }
}
