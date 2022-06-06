package model.service;

import model.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();

    void create(Customer customer);

    void detele(int id);

    void Edit(Customer customer);


    List<Customer> sreachCustomerName(String searchName);

}
