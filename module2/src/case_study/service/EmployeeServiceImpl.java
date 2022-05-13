package case_study.service;

import case_study.common.Exception.CheckException;
import case_study.common.readandwrite.ReadAndWrite;
import case_study.model.Employee;

import java.nio.file.StandardWatchEventKinds;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EmployeeServiceImpl implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);
    static List<Employee> employeeList = new ArrayList<>();
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private static final String FILE_EMPLOYEE = "case_study/common/data/employee.csv";

//    static {
//        Date date1 = null;
//        Date date2 = null;
//        Date date3 = null;
//        try {
//            date1 = dateFormat.parse("12-4-2001");
//            date2 = dateFormat.parse("12-4-20014");
//            date3 = dateFormat.parse("12-4-2006");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        employeeList.add(new Employee("luan", date1, "nam", 872383, 023424234, "uaasfa@gmail.com", 1, "cao dang", "quay ly", 10000));
//        employeeList.add(new Employee("hoan", date2, "nam", 452383, 02342344, "usdfsa@gmail.com", 2, "dai hoc", "nhan vien", 20000));
//        employeeList.add(new Employee("tai", date3, "nam", 877383, 02342434, "uaasdfya@gmail.com", 3, "dai hoc", "giam doc", 30000));
//
//        ReadAndWrite.writeEmployee(FILE_EMPLOYEE, employeeList);
//    }

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
        boolean flag = true;
        while (flag){
            try {
                String dateStr = scanner.nextLine();
                date = dateFormat.parse(dateStr);
                flag = false;
                break;
            } catch (ParseException e) {
                System.err.println(e.getMessage());
            }
        }

        System.out.print("Nhập giới tính: ");
        String gioiTinh = scanner.nextLine();

        System.out.print("Nhập CCCD: ");
        Integer cCCD = 0;
        CheckException.getCheckInteger(cCCD);

        System.out.print("Nhập số điện thoại: ");
        Integer soDienThoai = 0;
        CheckException.getCheckInteger(soDienThoai);

        System.out.print("Nhập Email: ");
        String email = scanner.nextLine();

        System.out.print("Nhập ID nhân viên: ");
        Integer id = 0;
        CheckException.getCheckInteger(id);

        System.out.print("Nhập trình độ nhân viên: ");
        String trinhDo = scanner.nextLine();

        System.out.print("Nhập vị trí của nhân viên: ");
        String viTri = scanner.nextLine();

        System.out.print("Nhập lương của nhân viên: ");
        Integer luong = 0;
        CheckException.getCheckInteger(luong);
        Employee employee = new Employee(ten, date, gioiTinh, cCCD, soDienThoai, email, id, trinhDo, viTri, luong);
        employeeList.add(employee);
        ReadAndWrite.writeEmployee(FILE_EMPLOYEE, employeeList);
    }

    @Override
    public void edit() {
        System.out.println("-----CHỈNH SỬA THÔNG TIN NHÂN VIÊN-----");

        ReadAndWrite.readFileEmployee(FILE_EMPLOYEE);
        System.out.print("Nhập tên nhân viên bạn tìm: ");
        String ten = scanner.nextLine();
        while (!isCheck(ten)) {
            System.out.println("-----KHÔNG TIN THẤY TÊN NHÂN VIÊN!-----");
            System.out.print("nhập lại tên nhân viên cần sửa:");
            ten = scanner.nextLine();
        }
        if (isCheck(ten)) {
            System.out.println("-----ĐÃ TÌM THẤY TÊN NHÂN VIÊN-----");
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getName().equals(ten)) {
                    System.out.print("Nhập tên nhân viên mới: ");
                    employeeList.get(i).setName(scanner.nextLine());

                    System.out.print("Nhập ngày sinh mới: ");
                    Date date = null;

                    String dateStr = scanner.nextLine();
                    try {
                        date = dateFormat.parse(dateStr);
                    } catch (ParseException e) {
                        System.err.println(e.getMessage());
                    }
                    employeeList.get(i).setDate(date);
                    System.out.print("Nhập giới tính mới: ");
                    employeeList.get(i).setGender(scanner.nextLine());

                    System.out.print("Nhập CCCD mới: ");
                    employeeList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                    System.out.print("Nhập số điện thoại mới: ");
                    employeeList.get(i).setPhone(Integer.parseInt(scanner.nextLine()));

                    System.out.print("Nhập Email mới: ");
                    employeeList.get(i).setEmail(scanner.nextLine());

                    System.out.print("Nhập ID nhân viên mới: ");
                    employeeList.get(i).setIdCard(Integer.parseInt(scanner.nextLine()));

                    System.out.print("Nhập trình độ nhân viên mới: ");
                    employeeList.get(i).setLevel(scanner.nextLine());

                    System.out.print("Nhập vị trí của nhân viên mới: ");
                    employeeList.get(i).setLocation(scanner.nextLine());

                    System.out.print("Nhập lương của nhân viên mới: ");
                    employeeList.get(i).setWage(Integer.parseInt(scanner.nextLine()));
                    ReadAndWrite.writeEmployee(FILE_EMPLOYEE, employeeList);
                }
            }
        }
    }

    private boolean isCheck(String ten) {
        for (Employee e : employeeList) {
            if (e.getName().equals(ten)) {
                return true;

            }
        }
        return false;
    }
}
