package model.service.impl;

import model.model.customer.Customer;
import model.repsitory.ICustomerRepsitory;
import model.repsitory.impl.CustomerRepsitoryImpl;
import model.service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepsitory iCustomerRepsitory = new CustomerRepsitoryImpl();

    @Override
    public List<Customer> getAll() {
        return iCustomerRepsitory.getAll();
    }

    @Override
    public void create(Customer customer) {
        iCustomerRepsitory.create(customer);
    }

    @Override
    public void detele(int id) {
        iCustomerRepsitory.detele(id);

    }

    @Override
    public void Edit(Customer customer) {
        iCustomerRepsitory.Edit(customer);
    }


    @Override
    public List<Customer> sreachCustomerName(String searchName) {
        return iCustomerRepsitory.sreachCustomerName(searchName);
    }

}
