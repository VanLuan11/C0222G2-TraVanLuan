package model.repsitory.impl;

import connection.DataBase;
import model.model.service.RentType;
import model.model.service.Service;
import model.model.service.ServiceType;
import model.repsitory.IServiceRepsitory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepsitoryImpl implements IServiceRepsitory {
    private static DataBase dataBase = new DataBase();
    private static final String SELECT_ALL_SERVICE = "select * from service where `status` =0;";
    private static final String SELECT_ALL_SERVICE_TYPE = "select * from service_type where `status` =0;";
    private static final String SELECT_ALL_RENT_TYPE = "select * from rent_type where `status` =0;";
    private static final String SELECT_SERVICE = "select * from service where service_id = ? and `status` =0;";
    private static final String CREATE_SERVICE = "insert into service (service_name, service_area, service_cost, service_max_people,rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors)  " +
            " values (?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_SERVICE = "update service set service_name = ? , service_area= ?, service_cost = ? , service_max_people = ? ,rent_type_id = ? , service_type_id = ? , standard_room = ? , description_other_convenience = ? , pool_area = ? , number_of_floors = ? where service_id = ? ; ";
    private static final String DELETE_SERVICE = "update service set `status` = 1  where service_id = ? ; ";
    private static final String SEARCH_NAME_AND_STANARD_ROOM ="select * from service where service_name like ? and standard_room like ? and `status`= 0;";

    @Override
    public List<Service> getALlService() {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                serviceList.add(new Service(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOC, poolArea, numberOfFloors));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return serviceList;
    }

    @Override
    public List<ServiceType> getAllServiceType() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serivceName = resultSet.getString("service_type_name");
                int status = resultSet.getInt("status");
                serviceTypeList.add(new ServiceType(serviceTypeId,serivceName,status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return serviceTypeList;
    }

    @Override
    public List<RentType> getAllRentType() {
        List<RentType> rentTypeList= new ArrayList<>();
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                int rentTypeCost = resultSet.getInt("rent_type_cost");
                int status = resultSet.getInt("status");
                rentTypeList.add(new RentType(rentTypeId,rentTypeName,rentTypeCost,status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return rentTypeList;
    }

    @Override
    public void create(Service service) {
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(CREATE_SERVICE);
            preparedStatement.setString(1,service.getServiceName());
            preparedStatement.setInt(2,service.getServiceArea());
            preparedStatement.setDouble(3,service.getServiceCost());
            preparedStatement.setInt(4,service.getServiceMaxPeople());
            preparedStatement.setInt(5,service.getRentTypeId());
            preparedStatement.setInt(6,service.getServiceTypeId());
            preparedStatement.setString(7,service.getStandardRoom());
            preparedStatement.setString(8,service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9,service.getPoolArea());
            preparedStatement.setInt(10,service.getNumberOfFloors());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

}
