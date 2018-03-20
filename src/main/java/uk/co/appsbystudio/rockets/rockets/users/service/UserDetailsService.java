package uk.co.appsbystudio.rockets.rockets.users.service;

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
        User user = userService.findUserByName(username);
        return new UserPrincipal(user);
    }
}
