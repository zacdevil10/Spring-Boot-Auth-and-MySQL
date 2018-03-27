package uk.co.appsbystudio.rockets.rockets.users.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.co.appsbystudio.rockets.rockets.users.UserPrincipal;
import uk.co.appsbystudio.rockets.rockets.users.model.User;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Load User By Username");
        User user = userService.findUserByName(username);
        System.out.println(user.getName());

        UserDetails userDetails = new UserPrincipal(user);

        return userDetails;
    }
}
