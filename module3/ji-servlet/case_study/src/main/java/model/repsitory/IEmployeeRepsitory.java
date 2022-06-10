package model.repsitory;

import model.model.employee.Division;
import model.model.employee.EducationDegree;
import model.model.employee.Employee;
import model.model.employee.Position;
import model.model.employee.User;

import java.util.List;

public interface IEmployeeRepsitory {
    List<Employee> getAll();

    void create(Employee employee);

    void detele(int id);

    List<Employee> sreachEmployee(String searchName, String searchAddress);

    void Edit(Employee employee);

    Employee getEmployeeEdit(int id);

    List<Position> getAllPosition();

    List<EducationDegree> getAllEducationDegree();

    List<Division> getAllDivision();

    List<User> getAllUser();
}
