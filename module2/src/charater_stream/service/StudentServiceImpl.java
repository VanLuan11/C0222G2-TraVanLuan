package charater_stream.service;

import charater_stream.model.Student;
import ss17_io_binary_file_and_serialization.bai_tap.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements IStudentService{
    Scanner scanner = new Scanner(System.in);
    static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "Hoàn", "đn", 10));
        studentList.add(new Student(2, "Tài chó điên", "đn", 9));

    }


    @Override
    public void add() {
        System.out.println("----------Thêm mới học sinh----------");
        System.out.println("Thêm mới id : ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Thêm mới tên: ");
        String ten = scanner.nextLine();
        System.out.println("Thêm mới địa chỉ : ");
        String diaChi = scanner.nextLine();
        System.out.println("Thêm mới điểm : ");
        Integer diem = Integer.parseInt(scanner.nextLine());
        Student student = new Student(id, ten, diaChi, diem);
        studentList.add(student);


    }

    @Override
    public void display() {

        for (Student a : studentList) {
            System.out.println(a);
        }
    }

    @Override
    public void search() {
        boolean flag = false;
        while (true) {
            System.out.println("---------Tìm kiếm học sinh----------");
            System.out.print("Nhập id học sinh bạn muốn tìm kiếm: ");
            int id = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getCodeStudent() == id) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("---------Đã tìm thấy ---------");
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getCodeStudent() == id) {
                        System.out.println(studentList.get(i));
                        return;
                    }
                }
            } else {
                System.out.println("---------Không tìm thấy ----------");
                System.out.println("Id học sinh: " + id + " không tìm thấy");
                return;
            }
        }
    }
}
