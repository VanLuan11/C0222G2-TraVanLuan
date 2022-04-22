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
        System.out.println("-----THÊM MỚI KHÁCH HÀNG-----");

        System.out.print("Nhập tên khách hàng: ");
        String ten = scanner.nextLine();

        System.out.print("Nhập ngày sinh khách hàng: ");
        String ngaySinh = scanner.nextLine();

        System.out.print("Nhập giới tính khách hàng: ");
        String gioiTinh = scanner.nextLine();

        System.out.print("Nhập CCCD khách hàng: ");
        Integer cCCD = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập số điện thoại khách hàng: ");
        String soDienThoai = scanner.nextLine();

        System.out.print("Nhập Email khách hàng: ");
        String email = scanner.nextLine();

        System.out.print("Nhập ID khách hàng: ");
        Integer id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập Loại khách hàng: ");
        String loaiKhach = scanner.nextLine();

        System.out.print("Nhập địa chỉ khách hàng: ");
        String diaChi = scanner.nextLine();
        Customer customer = new Customer(ten, ngaySinh, gioiTinh, cCCD, soDienThoai, email, id,loaiKhach ,diaChi);
        customerList.add(customer);

    }

    @Override
    public void edit() {
        System.out.println("-----CHỈNH SỬA THÔNG TIN KHÁCH HÀNG-----");

        System.out.print("Nhập tên nhân viên bạn cần sửa: ");
        String ten = scanner.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getName().equals(ten)) {
                System.out.print("Nhập tên khách hàng: ");
                customerList.get(i).setName(scanner.nextLine());

                System.out.print("Nhập ngày sinh khách hàng: ");
                customerList.get(i).setDate(scanner.nextLine());

                System.out.print("Nhập giới tính khách hàng: ");
                customerList.get(i).setGender(scanner.nextLine());

                System.out.print("Nhập CCCD khách hàng: ");
                customerList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập số điện thoại khách hàng: ");
                customerList.get(i).setPhone(scanner.nextLine());

                System.out.print("Nhập Email khách hàng: ");
                customerList.get(i).setEmail(scanner.nextLine());

                System.out.print("Nhập ID nhân viên khách hàng: ");
                customerList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập loại khách hàng: ");
                customerList.get(i).setTypeOfGuest(scanner.nextLine());

                System.out.print("Nhập địa chỉ khách hàng: ");
                customerList.get(i).setAddress(scanner.nextLine());
            }
        }
        display();

    }
}
