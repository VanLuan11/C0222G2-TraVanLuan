package model.service.impl;

import common.CheckRegex;
import model.model.employee.Division;
import model.model.employee.EducationDegree;
import model.model.employee.Employee;
import model.model.employee.Position;
import model.model.employee.User;
import model.repsitory.IEmployeeRepsitory;
import model.repsitory.impl.EmployeeRepositoryImpl;
import model.service.IEmployeeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {
    private static IEmployeeRepsitory iEmployeeRepsitory = new EmployeeRepositoryImpl();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<Employee> getAll() {
        return iEmployeeRepsitory.getAll();
    }

    @Override
    public Map<String, String> create(Employee employee) {
        Map<String, String> errMap =  new HashMap<>();
        List<Employee> employeeList = new ArrayList<>();
        boolean flag = false;
        if (employee.getEmployeeName() == null || employee.getEmployeeName().equals("")) {
            errMap.put("errEmployeeName", "Ủa không nhập tên thì lấy gì lưu?????");
        }
        if (employee.getEmployeeBirthday() == null || employee.getEmployeeBirthday().equals("")) {
            errMap.put("errEmployeeBirthday", "Đù trên trời rớt xuống à");
        } else {
            try {
                employee.setEmployeeBirthday(simpleDateFormat.format(simpleDateFormat.parse(employee.getEmployeeBirthday())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (employee.getEmployeeIdCard() == null || employee.getEmployeeIdCard().equals("")) {
            errMap.put("errIdCard", "Ủa không nhập thì lấy Card đâu ra ??");
        } else if (!CheckRegex.checkRegexCard(employee.getEmployeeIdCard())) {
            errMap.put("errIdCard", "Id Card XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)");
        }

        if (employee.getEmployeeSalary() == null || employee.getEmployeeSalary().equals("")) {
            errMap.put("errEmployeeSalary", "Đù đi làm không lương luôn ghê");
        }
//        if (employee.getEmployeeSalary() == null) {
//            try {
//                if (CheckRegex.checkSalary(employee.getEmployeeSalary())) ;
//            } catch (Exception e) {
//                e.getStackTrace();
//            }
//        } else {
//            errMap.put("errSalary", "ko de rong");
//        }

        if (employee.getEmployeePhone() == null || employee.getEmployeePhone().equals("")) {
            errMap.put("errEmployeePhone", "Ủa khônng nhập số điện thoại thì lấy gì gọi??");
        } else if (!CheckRegex.checkRegexPhone(employee.getEmployeePhone())) {
            errMap.put("errEmployeePhone", "Số điện thoại phải có 9 số và bắt đầu bằng 09-XXXXXXX hoặc 849-XXXXXXX nhé bạn!");
        }
        if (employee.getEmployeeEmail() == null || employee.getEmployeeEmail().equals("")) {
            errMap.put("errEmpoyeeEmail", "Email để trống nữa à");
        } else if (!CheckRegex.checkRegexEmail(employee.getEmployeeEmail())) {
            errMap.put("errEmpoyeeEmail", "Email không đúng định dạng (VD: taichodien69@gmail.com) nè bạn!");
        }
        if (employee.getEmployeeAddress() == null || employee.getEmployeeAddress().equals("")) {
            errMap.put("errEmployeeAddress", "Không có nhà để ở giống thị tài à tội thế :(");
        }
        for (Employee employee1 : employeeList) {
            if (employee1.getPositionId() == employee.getPositionId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errMap.put("errPositionId", "Làm người ai lại đi f12");
        }
        for (Employee employee1 : employeeList) {
            if (employee1.getEducationDegreeId() == employee.getEducationDegreeId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errMap.put("errEducationDegreeId", "Làm người ai lại đi f12");
        }
        for (Employee employee1 : employeeList) {
            if (employee1.getDivisionId() == employee.getDivisionId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errMap.put("errDivisionId", "Làm người ai lại đi f12");
        }
        if (errMap.isEmpty()) {
            iEmployeeRepsitory.create(employee);
        }
        return errMap;

    }

    @Override
    public void detele(int id) {
        iEmployeeRepsitory.detele(id);

    }

    @Override
    public Map<String, String> Edit(Employee employee) {
        Map<String, String> errMap = new HashMap<>();
        List<Employee> employeeList = iEmployeeRepsitory.getAll();
        boolean flag = false;
        if (employee.getEmployeeName() == null || employee.getEmployeeName().equals("")) {
            errMap.put("errEmployeeName", "Ủa không nhập tên thì lấy gì lưu?????");
        }
        if (employee.getEmployeeBirthday() == null || employee.getEmployeeBirthday().equals("")) {
            errMap.put("errEmployeeBirthday", "Đù trên trời rớt xuống à");
        } else {
            try {
                employee.setEmployeeBirthday(simpleDateFormat.format(simpleDateFormat.parse(employee.getEmployeeBirthday())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (employee.getEmployeeIdCard() == null || employee.getEmployeeIdCard().equals("")) {
            errMap.put("errIdCard", "Ủa không nhập thì lấy Card đâu ra ??");
        } else if (!CheckRegex.checkRegexCard(employee.getEmployeeIdCard())) {
            errMap.put("errIdCard", "Id Card XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)");
        }

        if (employee.getEmployeeSalary() == null || employee.getEmployeeSalary().equals("")) {
            errMap.put("errEmployeeSalary", "Đù đi làm không lương luôn ghê");
        }
//        if (employee.getEmployeeSalary() == null) {
//            try {
//                if (CheckRegex.checkSalary(employee.getEmployeeSalary())) ;
//            } catch (Exception e) {
//                e.getStackTrace();
//            }
//        } else {
//            errMap.put("errSalary", "ko de rong");
//        }

        if (employee.getEmployeePhone() == null || employee.getEmployeePhone().equals("")) {
            errMap.put("errEmployeePhone", "Ủa khônng nhập số điện thoại thì lấy gì gọi??");
        } else if (!CheckRegex.checkRegexPhone(employee.getEmployeePhone())) {
            errMap.put("errEmployeePhone", "Số điện thoại phải có 9 số và bắt đầu bằng 09-XXXXXXX hoặc 849-XXXXXXX nhé bạn!");
        }
        if (employee.getEmployeeEmail() == null || employee.getEmployeeEmail().equals("")) {
            errMap.put("errEmpoyeeEmail", "Email để trống nữa à");
        } else if (!CheckRegex.checkRegexEmail(employee.getEmployeeEmail())) {
            errMap.put("errEmpoyeeEmail", "Email không đúng định dạng (VD: taichodien69@gmail.com) nè bạn!");
        }
        if (employee.getEmployeeAddress() == null || employee.getEmployeeAddress().equals("")) {
            errMap.put("errEmployeeAddress", "Không có nhà để ở giống thị tài à tội thế :(");
        }
        for (Employee employee1 : employeeList) {
            if (employee1.getPositionId() == employee.getPositionId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errMap.put("errPositionId", "Làm người ai lại đi f12");
        }
        for (Employee employee1 : employeeList) {
            if (employee1.getEducationDegreeId() == employee.getEducationDegreeId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errMap.put("errEducationDegreeId", "Làm người ai lại đi f12");
        }
        for (Employee employee1 : employeeList) {
            if (employee1.getDivisionId() == employee.getDivisionId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errMap.put("errDivisionId", "Làm người ai lại đi f12");
        }
        if (errMap.isEmpty()) {
            iEmployeeRepsitory.create(employee);
        }
        return errMap;
    }

    @Override
    public List<Employee> sreachEmployee(String searchName, String searchAddress) {
        return iEmployeeRepsitory.sreachEmployee(searchName, searchAddress);
    }


    @Override
    public Employee getEmployeeEdit(int id) {
        return iEmployeeRepsitory.getEmployeeEdit(id);
    }


    @Override
    public List<Position> getAllPosition() {
        return iEmployeeRepsitory.getAllPosition();
    }

    @Override
    public List<EducationDegree> getAllEducationDegree() {
        return iEmployeeRepsitory.getAllEducationDegree();
    }

    @Override
    public List<Division> getAllDivision() {
        return iEmployeeRepsitory.getAllDivision();
    }

    @Override
    public List<User> getAllUser() {
        return iEmployeeRepsitory.getAllUser();
    }

}
