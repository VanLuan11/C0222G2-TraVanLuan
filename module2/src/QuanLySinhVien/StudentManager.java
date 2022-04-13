package QuanLySinhVien;

import java.util.Scanner;

public class StudentManager {
    Student[] student = new Student[100];
    Scanner scanner = new Scanner(System.in);

    public void add() {
        System.out.println("nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("nhập điểm:");
        int point = Integer.parseInt(scanner.nextLine());
        Student student = new Student(id, name, address, point);
        for (int i = 0; i < this.student.length; i++) {
            if (this.student[i] == null) {
                this.student[i] = student;
                break;
            }
        }
    }

    public void display() {
        for (int i = 0; i < this.student.length; i++) {
            if (this.student[i] != null) {
                System.out.println((i + 1) + "." + this.student[i].toString());
            } else {
                break;
            }
        }
    }

    public void edit() {
        boolean flag = false;
        System.out.print("Nhập id bạn muốn chỉnh sửa: ");
        int id = Integer.parseInt((new Scanner(System.in).nextLine()));
        for (int i = 0; i < student.length; i++) {
            if (student[i] != null && student[i].getId() == id) {
                student[i].input();
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Id " + id + " không tìm thấy!");
        }
    }

    public void delete() {
        System.out.println("nhập id cần xóa: ");
        int id = Integer.parseInt((new Scanner(System.in).nextLine()));

        for (int i = 0; i < student.length - 1; i++) {
            if (student[i] != null && student[i].getId() == id) {
                student[i] = student[i + 1];
                student[i + 1] = student[i];
            }
        }
    }
    public void search() {
        boolean flag = false;
        System.out.print("Nhập tên bạn muốn tìm ");
        String nameSearch = (new Scanner(System.in)).nextLine();
        Student [] os = new Student[100];

        for (int i = 0; i < student.length; i++) {
            if (student[i] != null) {
                if (student[i].getName().equalsIgnoreCase(nameSearch)) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            for (int i = 0; i < student.length; i++) {
                if (student[i] != null) {
                    if (student[i].getName().equalsIgnoreCase(nameSearch)) {
                        if (os[i] == null) {
                            os[i] = student[i];
                        }
                    }
                }
            }
            for (int i = 0; i < os.length; i++) {
                if (os[i] != null) {
                    System.out.println(os[i].output());
                }
            }
        } else {
            System.out.println(nameSearch + " không tìm thấy");
        }
    }
    public static void changeSchoolNameForAllStudent(){
        System.out.print("nhập trường cần thay đổi: ");
//        String nameschool =
        Student.school = "Bk";

    }
}
