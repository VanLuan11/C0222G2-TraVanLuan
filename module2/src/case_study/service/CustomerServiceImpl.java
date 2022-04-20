package case_study.service;

import case_study.model.Customer;
import case_study.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements IService{
    static Scanner scanner = new Scanner(System.in);
    static List<Customer> customerList = new ArrayList<>();
    static {
        Customer customerList1 = new Customer("luận", "1/4/4124", "nam", 872383, "093406069", "uaasfa@gmail.com", 1,"Diamond","Đà Nẵng");
        Customer customerList2 = new Customer("hoàng", "1/4/4124", "nam", 872383, "093406069", "uaasfa@gmail.com", 2,"Platinium","Huế");
        Customer customerList3 = new Customer("linh", "16/1/2001", "nữ", 872383, "093406069", "uaasfa@gmail.com", 3,"Diamond","Bắc Giang");


        customerList.add(customerList1);
        customerList.add(customerList2);
        customerList.add(customerList3);
    }


    @Override
    public void display() {
        System.out.println("-----Hiện thị danh sách-----");
        for (Customer hienthi : customerList) {
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
        Customer customer = new Customer(ten, ngaySinh, gioiTinh, cCCD, soDienThoai, email, id, trinhDo, viTri);
        customerList.add(customer);

    }

    @Override
    public void edit() {
        System.out.println("-----CHỈNH SỬA THÔNG TIN KHÁCH HÀNG-----");

        System.out.print("Nhập tên nhân viên bạn cần sửa: ");
        String ten = scanner.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getName() == ten) {
                System.out.print("Nhập tên nhân viên: ");
                customerList.get(i).setName(scanner.nextLine());

                System.out.print("Nhập ngày sinh: ");
                customerList.get(i).setDate(scanner.nextLine());

                System.out.print("Nhập giới tính: ");
                customerList.get(i).setGender(scanner.nextLine());

                System.out.print("Nhập CCCD: ");
                customerList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập số điện thoại: ");
                customerList.get(i).setPhone(scanner.nextLine());

                System.out.print("Nhập Email: ");
                customerList.get(i).setEmail(scanner.nextLine());

                System.out.print("Nhập ID nhân viên: ");
                customerList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập trình độ nhân viên: ");
                customerList.get(i).setIdCustomer(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập vị trí của nhân viên: ");
                customerList.get(i).setTypeOfGuest(scanner.nextLine());

                System.out.print("Nhập lương của nhân viên: ");
                customerList.get(i).setAddress(scanner.nextLine());

            }
        }display();

    }
}
