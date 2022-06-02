package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    void createUser(User user);

    void editUser(int id, String name, String email, String country);

    void delete(int id);

    List<User> searchConutry(String search);

    List<User> sortName();
}
