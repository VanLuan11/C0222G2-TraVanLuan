package model.service;

import model.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();

    void create(Customer customer);
}
