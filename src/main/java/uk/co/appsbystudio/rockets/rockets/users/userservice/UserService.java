package uk.co.appsbystudio.rockets.rockets.users.userservice;

import uk.co.appsbystudio.rockets.rockets.users.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findUserById(Integer id);
    User findUserByName(String name);
    User findUserByEmail(String name);
    User findUserByNameAndPassword(String name, String password);
    boolean isUserExist(User user);
    void saveUser(User user);
    void deleteUser(User user);

}
