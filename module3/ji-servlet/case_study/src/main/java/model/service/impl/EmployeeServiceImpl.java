package model.service.impl;

import model.model.Employee.Employee;
import model.model.customer.Customer;
import model.service.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private static IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    @Override
    public List<Employee> getAll() {
        return iEmployeeService.getAll();
    }

    @Override
    public void create(Employee employee) {
        iEmployeeService.create(employee);

    }

    @Override
    public void detele(int id) {
        iEmployeeService.detele(id);

    }

    @Override
    public void Edit(Employee employee) {
        iEmployeeService.Edit(employee);

    }

    @Override
    public List<Customer> sreachEmployeeName(String searchName) {
        return iEmployeeService.sreachEmployeeName(searchName);
    }

}
