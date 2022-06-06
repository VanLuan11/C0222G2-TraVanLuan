package model.repsitory;

import model.model.Customer;

import java.util.List;

public interface ICustomerRepsitory {
    List<Customer> getAll();

    void create(Customer customer);

    void detele(int id);


    List<Customer> sreachCustomerName(String searchName);

    void Edit(Customer customer);
}
