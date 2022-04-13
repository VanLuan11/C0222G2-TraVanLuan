package QuanLySinhVien;

import java.util.Scanner;

public class Main {
    // chương trình bắt đầu chạy tại đây
    public static void main(String[] args) {
        // Khởi tạo đối tượng để quản lý sinh viên
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("Chọn chức năng\n" +
                    "1. Display\n" +
                    "2.Add\n" +
                    "3.Update\n" +
                    "4.Delete\n" +
                    "5.Search\n" +
                    "6. Change school name for all student");
            System.out.print("Hãy chọn chức năng: ");
            int chooseMenue = Integer.parseInt(scanner.nextLine());
            switch (chooseMenue) {
                case 1:
                    studentManager.display();
                    break;
                case 2:
                    studentManager.add();
                    break;
                case 3:
                    studentManager.Update();
                    break;
                case 4:
                    studentManager.delete();
                    break;
                case 5:
                    studentManager.search();
                    break;
                case 6:
                    studentManager.changeSchoolNameForAllStudent();
                    break;
                default:
                    System.out.println("Đa thoát");
                    flag = false;
                    break;
            }
        } while (flag);

    }
}
