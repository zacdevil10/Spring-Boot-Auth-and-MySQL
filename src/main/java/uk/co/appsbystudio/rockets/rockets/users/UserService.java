package uk.co.appsbystudio.rockets.rockets.users;

public interface UserService {
    User findUserByEmail(String name);
    void saveUser(User user);

}
