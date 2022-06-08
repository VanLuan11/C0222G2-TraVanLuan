package model.repsitory.impl;

import connection.DataBase;
import model.model.employee.Division;
import model.model.employee.EducationDegree;
import model.model.employee.Employee;
import model.model.employee.Position;
import model.model.employee.User;
import model.repsitory.IEmployeeRepsitory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepsitory {
    private static DataBase dataBase = new DataBase();

    private static final String SELECT_ALL_EMPLOYEE = "select * from employee where `status`=0;";
    private static final String CREATE_EMPLOYEE = "insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id,user_name) values (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_EMPLPOYEE = "update employee set employee_name = ?,employee_birthday = ?,employee_id_card= ?,employee_salary=?,employee_phone= ?,employee_email= ?,employee_address=?,position_id= ?,education_degree_id=?,division_id=?,user_name=? where employee_id =?;";
    private static final String DELETE_EMPLPOYEE = "update employee set `status`=1 where employee_id = ?;";
    private static final String SEARCHNAME_EMPLPOYEE = "select * from employee where employee_name like ? and `status` =0;";
    private static final String SELECT_ALL_POSITION = " select * from position where status = 0;";
    private static final String SELECT_ALL_EDUCATION = " select * from education_degree where status = 0;  ";
    private static final String SELECT_ALL_DIVISION = " select * from division where status = 0;  ";
    private static final String SELECT_ALL_USER = " select * from user; ";
    private static final String SELECT_EMPLOYEE = " select * from employee where employee_id = ? ;";
//    private static final String FIND_BY_NAME_POSITION_id = "select * from employee where employee_name like ? and position_id like ? and `status` = 0;";

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_EMPLOYEE);
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String userName = resultSet.getString("user_name");
                employeeList.add(new Employee(id, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                        employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, userName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return employeeList;
    }

    @Override
    public void create(Employee employee) {
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUserName());
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLPOYEE);
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
    public List<Employee> sreachEmployeeName(String searchName) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCHNAME_EMPLPOYEE);
            preparedStatement.setString(1, "%" + searchName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String userName = resultSet.getString("user_name");
                employeeList.add(new Employee(id, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone,
                        employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, userName));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void Edit(Employee employee) {
        Connection connection = this.dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLPOYEE);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUserName());
            preparedStatement.setInt(12, employee.getEmployeeId());
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
    public Employee getEmployeeEdit(int id) {
        Employee employee = new Employee();
        Connection connection = dataBase.getConnectionJavaToDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("user_name");
                employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }


    @Override
    public List<Position> getAllPosition() {
        List<Position> positions = new ArrayList<>();
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                int status = resultSet.getInt("status");
                positions.add(new Position(positionId, positionName, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return positions;
    }

    @Override
    public List<EducationDegree> getAllEducationDegree() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int edId = resultSet.getInt("education_degree_id");
                String edName = resultSet.getString("education_degree_name");
                int status = resultSet.getInt("status");
                educationDegrees.add(new EducationDegree(edId, edName, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return educationDegrees;
    }

    @Override
    public List<Division> getAllDivision() {
        List<Division> divisions = new ArrayList<>();
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                int status = resultSet.getInt("status");
                divisions.add(new Division(divisionId, divisionName, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return divisions;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        Connection connection = dataBase.getConnectionJavaToDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String userName = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                int status = resultSet.getInt("status");
                users.add(new User(userName, password, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }
}
