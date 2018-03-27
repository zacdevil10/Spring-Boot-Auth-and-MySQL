package uk.co.appsbystudio.rockets.rockets.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import uk.co.appsbystudio.rockets.rockets.users.model.Session;
import uk.co.appsbystudio.rockets.rockets.users.model.User;
import uk.co.appsbystudio.rockets.rockets.users.sessionservice.SessionService;
import uk.co.appsbystudio.rockets.rockets.users.userservice.UserService;

import java.util.List;

@Controller
@RequestMapping(path = "/api/user")
public class UserAPIRequests {

    @Autowired
    public UserService userService;

    @Autowired
    public SessionService sessionService;

    //USERS

    /* RETRIEVE ALL USERS */
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /* RETRIEVE USER BY ID */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        System.out.println("Fetching user with id: " + id);
        User user = userService.findUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /* CREATE NEW USER */
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("Creating user " + user.getName());

        if (userService.isUserExist(user)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    /* UPDATE USER */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        System.out.println("Updating user with id " + id);

        User currentUser = userService.findUserById(id);

        if (currentUser == null) {
            System.out.println("User with id " + id + " was not found!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(user.getPassword());

        //TODO: Implement updating current user

        return null;
    }

    /* DELETE USER */
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id, @RequestBody User user) {
        userService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //SESSION

    /* RETRIEVE SESSION */
    @GetMapping("/{id}/session/{pID}")
    public ResponseEntity<Void> getUserSession(@PathVariable Integer id, @PathVariable String pID) {
        System.out.println("Fetching session for user with id: " + id);

        Session session = sessionService.findSessionByPID(pID);

        if (session == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //TODO: Return session (if valid) and user

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* CREATE NEW SESSION */
    @PostMapping("/{name}/session")
    public ResponseEntity<String> createSession(@PathVariable String name, @RequestBody User user) {
        User userDetails = userService.findUserByNameAndPassword(name, user.getPassword());

        if (userDetails == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String pID = sessionService.createSession(userDetails);

        return new ResponseEntity<>(pID, HttpStatus.CREATED);
    }

}
