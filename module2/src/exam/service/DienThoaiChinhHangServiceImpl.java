package exam.service;


import exam.common.readandwrite.ReadAndWrite;
import exam.model.DienThoaiChinhHang;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DienThoaiChinhHangServiceImpl implements IDienThoaiChinhHangService {
    static List<DienThoaiChinhHang> dienThoaiChinhHangList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private static final String FILE_CHINH_HANG = "exam/common/data/DienThoaiChinhHang.csv";

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

        System.out.print("Thêm mới thời gian bảo hành: ");
        String thoiGianBaohanh = scanner.nextLine();

        System.out.print("Thêm mới phạm vi bảo hành: ");
        String phamVi = scanner.nextLine();
        DienThoaiChinhHang dienThoaiChinhHang = new DienThoaiChinhHang(id,tenDienThoai,giaBan,soLuong,nhaSanXuat,thoiGianBaohanh,phamVi);
        dienThoaiChinhHangList.add(dienThoaiChinhHang);
        ReadAndWrite.writeDienThoaiChinhHang(FILE_CHINH_HANG,dienThoaiChinhHangList);
    }

    @Override
    public void diplay() {
        dienThoaiChinhHangList = ReadAndWrite.readFileDienThoaiChinhHang(FILE_CHINH_HANG);
        System.out.println("-----HIỂN THỊ DANH SÁCH ĐIỆN THOẠI CHÍNH HÃNG-----");
        if(!dienThoaiChinhHangList.isEmpty()){
            for (DienThoaiChinhHang d : dienThoaiChinhHangList) {
                System.out.println(d);
            }
        }else {
            System.out.println("Danh sách rỗng!!");
        }

    }

    @Override
    public void delete() {
        dienThoaiChinhHangList = ReadAndWrite.readFileDienThoaiChinhHang(FILE_CHINH_HANG);
        System.out.println("-----TÌM KIẾM MUỐN XOÁ-----");
        System.out.print("Nhập id cần xoá: ");
        Integer id  = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        for (int i = 0; i < dienThoaiChinhHangList.size(); i++) {
            if (dienThoaiChinhHangList.get(i).getId() == id ) {
                System.out.println("Xoá thành công!");
                dienThoaiChinhHangList.remove(i);
                flag = false;
            }
            ReadAndWrite.writeDienThoaiChinhHang(FILE_CHINH_HANG,dienThoaiChinhHangList);
        }diplay();
        if (flag) {
            System.err.println("Không tìm thấy!");
        }


    }


    @Override
    public void search() {
        dienThoaiChinhHangList = ReadAndWrite.readFileDienThoaiChinhHang(FILE_CHINH_HANG);
        System.out.println("-----TÌM KIẾM-----"); 
        System.out.println("nhập id muốn tìm kiếm");
        Integer id = Integer.parseInt(scanner.nextLine());
        while (!check(id)){
            System.out.println("không tìm thấy");
            System.out.print("Nhập lại: ");
            id = Integer.parseInt(scanner.nextLine());
        }
        if(check(id)){
            for (DienThoaiChinhHang d : dienThoaiChinhHangList) {
                if(d.getId() == id){
                    System.out.println(d);
                }
            }
        }

    }

    public boolean check(Integer integer) {
        for (DienThoaiChinhHang d : dienThoaiChinhHangList) {
            if (d.getId() == integer ) {
                return true;
            }
        }
        return false;
    }
}
