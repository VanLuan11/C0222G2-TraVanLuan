package repository.impl;

import connection.DataBase;
import model.User;
import repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private static DataBase dataBase = new DataBase();

    private static final String USER_SELECT_SQL = "select * from users";
    private static final String USER_UPDATE_SQL = "update users set name = ?, email = ?, country = ? where id = ?;";
    private static final String USER_CREATE_SQL = "insert  into users(name,email,country) values(?,?,?)";
    private static final String USER_DELETE_SQL = "delete from users  where id = ?;";
    private static final String USER_SEARCH_SQL = "select*from users where country like ?";
    private static final String USER_SORT_SQL = "select * from users order by name;";


    @Override

    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(USER_SELECT_SQL);
            while (resultSet.next()) {
                int idUser = resultSet.getInt("id");
                String nameUser = resultSet.getString("name");
                String emailUser = resultSet.getString("email");
                String countryUser = resultSet.getString("country");
                userList.add(new User(idUser, nameUser, emailUser, countryUser));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public void createUser(User user) {
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(USER_CREATE_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
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
    public void updateUser(int id, String name, String email, String country) {
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(USER_UPDATE_SQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, country);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void deleteUser(int id) {
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(USER_DELETE_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<User> searchConutry(String search) {
        List<User> users = new ArrayList<>();
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(USER_SEARCH_SQL);
            preparedStatement.setString(1,"%"+ search+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(id,name, email, country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;

    }

    @Override
    public List<User> sortName() {
        List<User> users = new ArrayList<>();
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            Statement statement =connection.createStatement();
            ResultSet resultSet = statement.executeQuery(USER_SORT_SQL);
            while (resultSet.next()){
                int id  = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("counrty");
                users.add(new User(id,name,email,country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}
