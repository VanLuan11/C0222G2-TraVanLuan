package model.repsitory;

import model.model.Employee.Employee;
import model.model.customer.Customer;

import java.util.List;

public interface  IEmployeeRepsitory {
    List<Employee> getAll();

    void create(Employee employee);

    void detele(int id);

    List<Customer> sreachCustomerName(String searchName);

    void Edit(Employee employee);
}
