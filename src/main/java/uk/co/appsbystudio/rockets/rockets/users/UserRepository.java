package uk.co.appsbystudio.rockets.rockets.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Integer id);
    User findUserByEmail(String email);
    User findUserByName(String name);
}
