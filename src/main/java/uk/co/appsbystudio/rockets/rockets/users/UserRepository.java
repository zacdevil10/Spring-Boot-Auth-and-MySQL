package uk.co.appsbystudio.rockets.rockets.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.co.appsbystudio.rockets.rockets.users.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Integer id);
    User findUserByEmail(String email);
    User findUserByName(String name);
}
