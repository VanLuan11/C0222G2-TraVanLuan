package com.luan.validation_login.service;

import com.luan.validation_login.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);

    void delete(Integer id);

    void update(User user);

    User getUser(Integer id);
}
