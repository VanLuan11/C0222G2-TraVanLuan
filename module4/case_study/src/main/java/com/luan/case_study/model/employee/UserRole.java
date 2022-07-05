//package com.luan.case_study.model.employee;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user_role")
//public class UserRole {
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
//    private Role role;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "user_name",referencedColumnName = "user_name")
//    private User user;
//
//    private int status;
//
//    public UserRole() {
//    }
//
//    public UserRole(Role role, User user, int status) {
//        this.role = role;
//        this.user = user;
//        this.status = status;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//}
