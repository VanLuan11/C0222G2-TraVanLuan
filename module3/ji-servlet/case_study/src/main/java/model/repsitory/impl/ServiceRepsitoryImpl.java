package model.repsitory.impl;

import connection.DataBase;
import model.model.service.Service;
import model.repsitory.IServiceRepsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepsitoryImpl implements IServiceRepsitory {
    private static DataBase dataBase = new DataBase();
    private static final String SELECT_ALL_SERVICE="select * from service where `status` =0;";
    @Override
    public List<Service> getALlService() {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                double serviceCost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOC = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                serviceList.add(new Service(serviceId,serviceName,serviceArea,serviceCost,serviceMaxPeople,rentTypeId,serviceTypeId,standardRoom,descriptionOC,poolArea,numberOfFloors));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

//    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
//            preparedStatement.setString();
//            preparedStatement.setInt();
//            preparedStatement.setDouble();
//            preparedStatement.setInt();
//            preparedStatement.setInt();
//            preparedStatement.setInt();
//            preparedStatement.setString();
//            preparedStatement.setString();
//            preparedStatement.setDouble();
//            preparedStatement.setInt();
}
