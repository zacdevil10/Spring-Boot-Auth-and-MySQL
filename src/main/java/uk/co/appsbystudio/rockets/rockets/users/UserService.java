package uk.co.appsbystudio.rockets.rockets.users;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findUserById(Integer id);
    User findUserByName(String name);
    User findUserByEmail(String name);
    boolean isUserExist(User user);
    void saveUser(User user);

}
