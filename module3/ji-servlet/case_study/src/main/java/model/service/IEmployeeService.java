package model.service;

import model.model.employee.Division;
import model.model.employee.EducationDegree;
import model.model.employee.Employee;
import model.model.employee.Position;
import model.model.employee.User;


import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    List<Employee> getAll();

    Map<String, String> create(Employee employee);

    void detele(int id);

    Map<String , String> Edit(Employee employee);

    List<Employee> sreachEmployee(String searchName, String searchAddress);

    Employee getEmployeeEdit(int id);

    List<Position> getAllPosition();

    List<EducationDegree> getAllEducationDegree();

    List<Division> getAllDivision();

    List<User> getAllUser();
}
