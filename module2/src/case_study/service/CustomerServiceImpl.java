package case_study.service;

import case_study.common.readandwrite.ReadAndWrite;
import case_study.model.Customer;
import case_study.model.Employee;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerServiceImpl implements IService {
    static Scanner scanner = new Scanner(System.in);
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private static final String FILE_CUSTOMER = "src/case_study/common/data/customer.csv";
    static List<Customer> customerList = new LinkedList<>();

    static {
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        try{
            date1 = dateFormat.parse("12-4-2011");
            date2 = dateFormat.parse("12-7-2014");
            date3 = dateFormat.parse("12-4-2004");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        customerList.add(new Customer("luan", date1, "nam", 872383, "093406069", "uaasfa@gmail.com", 1, "Diamond", "Đà Nẵng"));
        customerList.add(new Customer("hoang", date2, "nam", 872383, "093406069", "uaasfa@gmail.com", 2, "Platinium", "Huế"));
        customerList.add(new Customer("tai", date3, "nam", 872383, "093406069", "uaasfa@gmail.com", 3, "Diamond", "Hà Nội"));

        ReadAndWrite.writeCustomer(FILE_CUSTOMER,customerList);
    }


    @Override
    public void display() {
        System.out.println("-----Hiện thị danh sách-----");
        customerList = ReadAndWrite.readFileCustomer(FILE_CUSTOMER);
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
        Date date = null;
         String dataStr = scanner.nextLine();

        try {
            date = dateFormat.parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
        Customer customer = new Customer(ten, date, gioiTinh, cCCD, soDienThoai, email, id, loaiKhach, diaChi);
        customerList.add(customer);
ReadAndWrite.writeCustomer(FILE_CUSTOMER,customerList);
    }

    @Override
    public void edit() {
        System.out.println("-----CHỈNH SỬA THÔNG TIN KHÁCH HÀNG-----");

        System.out.print("Nhập tên khách hàng bạn cần sửa: ");
        String ten = scanner.nextLine();
        boolean check = false;
        while (!check){
            System.out.print("Nhập lại tên khách hàng cần sửa:  ");
            ten = scanner.nextLine();
            for (Customer c: customerList) {
                if(c.getName().equals(ten)){
                    check = true;
                    break;
                }
            }
        }
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getName().equals(ten)) {
                System.out.print("Nhập tên khách hàng cần sửa: ");
                customerList.get(i).setName(scanner.nextLine());

                System.out.print("Nhập ngày sinh khách hàng cần sửa: ");
                Date date = null;
                String dateStr = scanner.nextLine();
                try {
                    date = dateFormat.parse(dateStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                customerList.get(i).setDate(date);
                System.out.print("Nhập giới tính khách hàng cần sửa: ");
                customerList.get(i).setGender(scanner.nextLine());

                System.out.print("Nhập CCCD khách hàng cần sửa: ");
                customerList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập số điện thoại khách hàng cần sửa: ");
                customerList.get(i).setPhone(scanner.nextLine());

                System.out.print("Nhập Email khách hàng cần sửa: ");
                customerList.get(i).setEmail(scanner.nextLine());

                System.out.print("Nhập ID nhân viên khách hàng cần sửa: ");
                customerList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập loại khách hàng cần sửa: ");
                customerList.get(i).setTypeOfGuest(scanner.nextLine());

                System.out.print("Nhập địa chỉ khách hàng cần sửa: ");
                customerList.get(i).setAddress(scanner.nextLine());
                ReadAndWrite.writeCustomer(FILE_CUSTOMER,customerList);
            }
        }
    }
}
