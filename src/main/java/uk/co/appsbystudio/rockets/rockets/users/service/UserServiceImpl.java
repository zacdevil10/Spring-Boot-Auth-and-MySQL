package uk.co.appsbystudio.rockets.rockets.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uk.co.appsbystudio.rockets.rockets.users.UserRepository;
import uk.co.appsbystudio.rockets.rockets.users.model.User;

import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public boolean isUserExist(User user) {
        return findUserByEmail(user.getEmail()) != null;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCreated(new Date());
        user.setPictureUri("/" + user.getName() + "/profile.png");
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
