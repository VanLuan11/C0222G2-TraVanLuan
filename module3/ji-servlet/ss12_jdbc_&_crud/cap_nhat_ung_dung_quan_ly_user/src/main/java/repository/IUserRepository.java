package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
  List<User> getAll();
  void createUser(User user);
  void updateUser(int id, String name, String email, String country);
  void deleteUser(int id);
}
