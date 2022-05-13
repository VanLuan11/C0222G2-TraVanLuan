package bai_thi.service;

import bai_thi.common.Exception;
import bai_thi.common.ReadAndWrite2;
import bai_thi.common.Regex;
import bai_thi.common.RegexEception;
import bai_thi.model.SuatChieu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class QuanLySuatPhimImpl implements IQuanLySuatPhim {
    Scanner scanner = new Scanner(System.in);
    private final static String DATE = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(DATE);
    private static final String FILE_SUAT_CHIEU = "bai_thi/common/SuatChieu.csv";
    static List<SuatChieu> suatChieuList = new LinkedList<>();

    @Override
    public void diplayy() {
        suatChieuList = ReadAndWrite2.readFileSuatChieu(FILE_SUAT_CHIEU);
        if (!suatChieuList.isEmpty()) {
            for (SuatChieu s : suatChieuList) {
                System.out.println(s);
            }
        } else {
            try {
                throw new RegexEception("danh sách rỗng");
            } catch (RegexEception regexEception) {
                regexEception.printStackTrace();
            }
        }

    }

    @Override
    public void add() {
        System.out.println("-----THÊM MỚI SUẤT CHIẾU-----");

//        System.out.print("Thêm mới mã suất chiếu: ");
        String maChieu = Regex.maSuatPhim();
//        while (!Regex.maSuatChieu(maChieu)){
//            System.out.println("không đúng định dạng!");
//            System.out.print("nhận lại ma suất chiếu: ");
//            maChieu = scanner.nextLine();
//        }

        System.out.print("Thêm mới tên phim: ");
        String tenPhim = scanner.nextLine();
//        while (!Regex.tenPhim(tenPhim)){
//            System.out.println("không đúng định dạng");
//            System.out.println("Nhập lại tên phim: ");
//            tenPhim = scanner.nextLine();
//        }


        System.out.print("Thêm mới ngày chiếu: ");
        Date date = null;
        boolean check = true;
        while (check) {
            try {
                String strDate = scanner.nextLine();
                date = dateFormat.parse(strDate);
                check = false;
                break;
            } catch (ParseException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.print("Thêm mới số lượng vé: ");
        Integer soVe = 0;
        soVe = Exception.exception(soVe);

        SuatChieu suatChieu = new SuatChieu(maChieu, tenPhim, date, soVe);
        suatChieuList.add(suatChieu);
        ReadAndWrite2.writeSuatChieu(FILE_SUAT_CHIEU, suatChieuList);
    }

    @Override
    public void detele() {
        suatChieuList = ReadAndWrite2.readFileSuatChieu(FILE_SUAT_CHIEU);
        System.out.print("Nhập mã suất chiếu cần xoá: ");
        String maChieu = scanner.nextLine();
        boolean flag = true;
        for (int i = 0; i < suatChieuList.size(); i++) {
            if (suatChieuList.get(i).getMaSuatChieu().equals(maChieu)) {
                System.out.println("xoá thành công");
                suatChieuList.remove(i);
                flag = false;
            }
        }
        if (flag) {
            System.err.println("không tìm thấy!");
        }
        ReadAndWrite2.writeSuatChieu(FILE_SUAT_CHIEU, suatChieuList);
    }

    @Override
    public void sort() {
        suatChieuList = ReadAndWrite2.readFileSuatChieu(FILE_SUAT_CHIEU);
        Collections.sort(suatChieuList, new Comparator<SuatChieu>() {
            @Override
            public int compare(SuatChieu o1, SuatChieu o2) {
                return o1.getSoLuongVe() - o2.getSoLuongVe();
            }
        });
        ReadAndWrite2.writeSuatChieu(FILE_SUAT_CHIEU, suatChieuList);
    }

    @Override
    public void edit() {
        System.out.println("-----SỬA ĐỔI SUẤT PHIM-----");
        suatChieuList = ReadAndWrite2.readFileSuatChieu(FILE_SUAT_CHIEU);
        System.out.println("Nhập mã suất chiếu để tìm kiếm: ");
        String maChieu = scanner.nextLine();
        while (!check(maChieu)) {
            System.out.println("-----KHÔNG TÌM THẤY MÃ SUẤT CHIẾU-----");
            System.out.println("Nhập lại mã suất chiếu: ");
            maChieu = scanner.nextLine();
        }
        if (check(maChieu)) {
            System.out.println("-----ĐÃ TÌM THẤY MÃ SUẤT CHIẾU-----");
            for (int i = 0; i < suatChieuList.size(); i++) {
                if (suatChieuList.get(i).equals(maChieu)) {
                    System.out.println("Nhập lại mã suất chiếu: ");
                    suatChieuList.get(i).setMaSuatChieu(scanner.nextLine());
                    System.out.println("Nhập lại tên phim: ");
                    suatChieuList.get(i).setTenPhim(scanner.nextLine());
                    System.out.println("Nhập lại ngày chiếu mới: ");
                    Date date = null;
                    boolean check = true;
                    while (check) {
                        try {
                            String dateStr = scanner.nextLine();
                            date = dateFormat.parse(dateStr);
                        } catch (ParseException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    System.out.println("Nhập lại số lượng vé: ");
                    suatChieuList.get(i).setSoLuongVe(Integer.parseInt(scanner.nextLine()));
                    ReadAndWrite2.writeSuatChieu(FILE_SUAT_CHIEU, suatChieuList);
                }
            }
        }
    }

    public boolean check(String maChieu) {
        for (SuatChieu s : suatChieuList) {
            if (s.getMaSuatChieu().equals(maChieu)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void search() {
        suatChieuList = ReadAndWrite2.readFileSuatChieu(FILE_SUAT_CHIEU);
        System.out.println("nhập mã phim muốn tìm kiếm");
        String machieu = scanner.nextLine();
        while (!check(machieu)){
            System.out.println("không tìm thấy");
            System.out.print("Nhập lại mã suất chiếu: ");
            machieu = scanner.nextLine();
        }
        if(check(machieu)){
            for (SuatChieu s : suatChieuList) {
                if(s.getMaSuatChieu().equals(machieu)){
                    System.out.println(s);
                }
            }
        }
    }

}
