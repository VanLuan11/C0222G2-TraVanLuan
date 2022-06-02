package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepositoryImpl;
import service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserRepository iUserRepository = new UserRepositoryImpl();

    @Override
    public List<User> getAll() {
        return this.iUserRepository.getAll();
    }

    @Override
    public void createUser(User user) {
        iUserRepository.createUser(user);
    }

    @Override
    public void editUser(int id, String name, String email, String country) {
        iUserRepository.updateUser(id,name,email,country);
    }

    @Override
    public void delete(int id) {
        iUserRepository.deleteUser(id);
    }

    @Override
    public List<User> searchConutry(String search) {
        return iUserRepository.searchConutry(search);
    }

    @Override
    public List<User> sortName() {
        return iUserRepository.sortName();
    }
}
