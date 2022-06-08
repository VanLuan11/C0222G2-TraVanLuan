package model.service.impl;

import model.model.employee.Division;
import model.model.employee.EducationDegree;
import model.model.employee.Employee;
import model.model.employee.Position;
import model.model.employee.User;
import model.repsitory.IEmployeeRepsitory;
import model.repsitory.impl.EmployeeRepositoryImpl;
import model.service.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private static IEmployeeRepsitory iEmployeeRepsitory = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> getAll() {
        return iEmployeeRepsitory.getAll();
    }

    @Override
    public void create(Employee employee) {
        iEmployeeRepsitory.create(employee);

    }

    @Override
    public void detele(int id) {
        iEmployeeRepsitory.detele(id);

    }

    @Override
    public void Edit(Employee employee) {
        iEmployeeRepsitory.Edit(employee);

    }

    @Override
    public List<Employee> sreachEmployeeName(String searchName) {
        return iEmployeeRepsitory.sreachEmployeeName(searchName);
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
