package case_study.service;

import case_study.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);
    static List<Employee> employeeList = new ArrayList<>();

    static {
        Employee employee1 = new Employee("luan", "1/4/4124", "nam", 872383, "093406069", "uaasfa@gmail.com", 1, "cao dang", "quay ly", 10000);
        Employee employee2 = new Employee("hoan", "5/5/4134", "nam", 452383, "093422289", "usdfsa@gmail.com", 2, "dai hoc", "nhan vien", 20000);
        Employee employee3 = new Employee("tai", "4/4/4124", "nam", 877383, "093484289", "uaasdfya@gmail.com", 3, "dai hoc", "giam doc", 30000);

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
    }

    @Override
    public void display() {
        System.out.println("-----Hiện thị danh sách-----");
        for (Employee hienthi : employeeList) {
            System.out.println(hienthi);
        }
    }

    @Override
    public void add() {
        System.out.println("-----THÊM MỚI NHÂN VIÊN-----");

        System.out.print("Nhập tên nhân viên: ");
        String ten = scanner.nextLine();

        System.out.print("Nhập ngày sinh: ");
        String ngaySinh = scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        String gioiTinh = scanner.nextLine();

        System.out.print("Nhập CCCD: ");
        Integer cCCD = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập số điện thoại: ");
        String soDienThoai = scanner.nextLine();

        System.out.print("Nhập Email: ");
        String email = scanner.nextLine();

        System.out.print("Nhập ID nhân viên: ");
        Integer id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập trình độ nhân viên: ");
        String trinhDo = scanner.nextLine();

        System.out.print("Nhập vị trí của nhân viên: ");
        String viTri = scanner.nextLine();

        System.out.print("Nhập lương của nhân viên: ");
        Integer luong = Integer.parseInt(scanner.nextLine());
        Employee employee = new Employee(ten, ngaySinh, gioiTinh, cCCD, soDienThoai, email, id, trinhDo, viTri, luong);
        employeeList.add(employee);

    }

    @Override
    public void edit() {
        System.out.println("-----CHỈNH SỬA THÔNG TIN NHÂN VIÊN-----");

        System.out.print("Nhập tên nhân viên bạn cần sửa: ");
        String ten = scanner.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getName().equals(ten)) {
                System.out.print("Nhập tên nhân viên: ");
                employeeList.get(i).setName(scanner.nextLine());

                System.out.print("Nhập ngày sinh: ");
                employeeList.get(i).setDate(scanner.nextLine());

                System.out.print("Nhập giới tính: ");
                employeeList.get(i).setGender(scanner.nextLine());

                System.out.print("Nhập CCCD: ");
                employeeList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập số điện thoại: ");
                employeeList.get(i).setPhone(scanner.nextLine());

                System.out.print("Nhập Email: ");
                employeeList.get(i).setEmail(scanner.nextLine());

                System.out.print("Nhập ID nhân viên: ");
                employeeList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập trình độ nhân viên: ");
                employeeList.get(i).setLevel(scanner.nextLine());

                System.out.print("Nhập vị trí của nhân viên: ");
                employeeList.get(i).setLocation(scanner.nextLine());

                System.out.print("Nhập lương của nhân viên: ");
                employeeList.get(i).setWage(Integer.parseInt(scanner.nextLine()));

            }
        }display();
    }
}
