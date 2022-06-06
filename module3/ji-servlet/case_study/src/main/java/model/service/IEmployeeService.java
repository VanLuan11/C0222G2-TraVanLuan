package model.service;

import model.model.Employee.Employee;
import model.model.customer.Customer;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();

    void create(Employee employee);

    void detele(int id);

    void Edit(Employee employee);

    List<Customer> sreachEmployeeName(String searchName);
}
