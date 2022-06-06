package model.repsitory.impl;

import connection.DataBase;
import model.model.customer.Customer;
import model.repsitory.ICustomerRepsitory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepsitoryImpl implements ICustomerRepsitory {
    private static DataBase dataBase = new DataBase();

    private static final String SELECT_CUSTOMER = "select * from customer where `status`=0;";
    private static final String CREATE_CUSTOMER = "insert into customer (customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) value (?,?,?,?,?,?,?,?);";
    private static final String UPDATE_CUSTOMER = "update customer set customer_type_id = ?,customer_name= ?,customer_birthday= ?,customer_gender= ?,customer_id_card= ?,customer_phone= ?,customer_email= ?,customer_address= ? where customer_id = ?;";
    private static final String DELETE_CUSTOMER = "update customer set `status`= 1 where customer_id = ?;";
    private static final String SEARCHNAME_CUSTOMER = "select * from customer where customer_name like ? and `status` =0;";

    @Override

    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_CUSTOMER);
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id, customerTypeId, name, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void create(Customer customer) {
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setInt(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void detele(int id) {
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void Edit(Customer customer) {
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setInt(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9,customer.getCustomerId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public List<Customer> sreachCustomerName(String searchName) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCHNAME_CUSTOMER);
            preparedStatement.setString(1, "%" + searchName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id, customerTypeId, name, birthday, gender, idCard, phone, email, address));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
