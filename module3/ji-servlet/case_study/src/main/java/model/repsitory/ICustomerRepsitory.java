package model.repsitory;

import model.model.Customer;

import java.util.List;

public interface ICustomerRepsitory {
    List<Customer> getAll();

    void create(Customer customer);
}
