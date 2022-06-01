package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepositoryImpl;
import service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserRepository iUserRepository = new UserRepositoryImpl();
    List<User> users = this.iUserRepository.getAll();

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void createUser(User user) {
        iUserRepository.createUser(user);
    }

    @Override
    public void editUser(int id, String name, String email, String country) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void search(String name) {

    }

    @Override
    public void sort(String name) {

    }
}
