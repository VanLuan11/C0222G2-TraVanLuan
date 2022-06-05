package model.service.impl;

import model.model.Customer;
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
}
