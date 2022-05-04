package case_study.service;

import case_study.common.readandwrite.ReadAndWrite;
import case_study.model.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeServiceImpl implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);
    static List<Employee> employeeList = new ArrayList<>();
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private static final String FILE_EMPLOYEE = "src/case_study/common/data/employee.csv";

    static {
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        try {
            date1 = dateFormat.parse("12-4-2001");
            date2 = dateFormat.parse("12-4-20014");
            date3 = dateFormat.parse("12-4-2006");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        employeeList.add(new Employee("luan", date1, "nam", 872383, "093406069", "uaasfa@gmail.com", 1, "cao dang", "quay ly", 10000));
        employeeList.add(new Employee("hoan", date2, "nam", 452383, "093422289", "usdfsa@gmail.com", 2, "dai hoc", "nhan vien", 20000));
        employeeList.add(new Employee("tai", date3, "nam", 877383, "093484289", "uaasdfya@gmail.com", 3, "dai hoc", "giam doc", 30000));

        ReadAndWrite.writeEmployee(FILE_EMPLOYEE,employeeList);
    }

    @Override
    public void display() {
        employeeList = ReadAndWrite.readFileEmployee(FILE_EMPLOYEE);
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
        Date date = null;

        String dateStr = scanner.nextLine();
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
        Employee employee = new Employee(ten, date, gioiTinh, cCCD, soDienThoai, email, id, trinhDo, viTri, luong);
        employeeList.add(employee);
ReadAndWrite.writeEmployee(FILE_EMPLOYEE,employeeList);
    }

    @Override
    public void edit() {
        System.out.println("-----CHỈNH SỬA THÔNG TIN NHÂN VIÊN-----");
        System.out.print("Nhập tên nhân viên bạn cần sửa: ");
        String ten = scanner.nextLine();
        boolean check = false;
        while (!check) {
            System.out.print("nhập lại tên nhân viên cần sửa:");
            ten = scanner.nextLine();
            for (Employee e : employeeList) {
                if (e.getName().equals(ten)) {
                    check = true;
                    break;
                }
            }
        }
        if (check) {
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getName().equals(ten)) {
                    System.out.print("Nhập tên nhân viên cần sửa: ");
                    employeeList.get(i).setName(scanner.nextLine());

                    System.out.print("Nhập ngày sinh cần sửa: ");
                    Date date = null;

                    String dateStr = scanner.nextLine();
                    try {
                        date = dateFormat.parse(dateStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    employeeList.get(i).setDate(date);
                    System.out.print("Nhập giới tính cần sửa: ");
                    employeeList.get(i).setGender(scanner.nextLine());

                    System.out.print("Nhập CCCD cần sửa: ");
                    employeeList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                    System.out.print("Nhập số điện thoại cần sửa: ");
                    employeeList.get(i).setPhone(scanner.nextLine());

                    System.out.print("Nhập Email cần sửa: ");
                    employeeList.get(i).setEmail(scanner.nextLine());

                    System.out.print("Nhập ID nhân viên cần sửa: ");
                    employeeList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                    System.out.print("Nhập trình độ nhân viên cần sửa : ");
                    employeeList.get(i).setLevel(scanner.nextLine());

                    System.out.print("Nhập vị trí của nhân viên cần sửa: ");
                    employeeList.get(i).setLocation(scanner.nextLine());

                    System.out.print("Nhập lương của nhân viên cần sửa: ");
                    employeeList.get(i).setWage(Integer.parseInt(scanner.nextLine()));
                    ReadAndWrite.writeEmployee(FILE_EMPLOYEE,employeeList);
                }
            }
        }
    }
}
