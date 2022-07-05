//package com.luan.case_study.model.employee;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table
//public class User {
//    @Id
//    @Column(name = "user_name")
//    private String userName;
//    private String password;
//    private int status;
//
//    @JsonBackReference
//    @OneToMany(mappedBy = "user")
//    private List<Employee> employees;
//
//    @JsonBackReference
//    @OneToMany(mappedBy = "user")
//    private List<UserRole> userRoles;
//
//    public User() {
//    }
//
//    public User(String userName, String password, int status, List<Employee> employees, List<UserRole> userRoles) {
//        this.userName = userName;
//        this.password = password;
//        this.status = status;
//        this.employees = employees;
//        this.userRoles = userRoles;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }
//
//    public List<UserRole> getUserRoles() {
//        return userRoles;
//    }
//
//    public void setUserRoles(List<UserRole> userRoles) {
//        this.userRoles = userRoles;
//    }
//}
