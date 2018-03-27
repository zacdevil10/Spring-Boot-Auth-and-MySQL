package uk.co.appsbystudio.rockets.rockets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.co.appsbystudio.rockets.rockets.rockets.Rocket;
import uk.co.appsbystudio.rockets.rockets.rockets.RocketService;
import uk.co.appsbystudio.rockets.rockets.users.model.User;
import uk.co.appsbystudio.rockets.rockets.users.userservice.UserService;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private RocketService rocketService;

    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByName(auth.getName());
        if (user != null) {
            modelAndView.addObject("name", "Welcome " + user.getName());
            modelAndView.addObject("login", "display: none;");
            modelAndView.addObject("logout", "display: block;");
        } else {
            modelAndView.addObject("name", "Welcome.\nPlease log in.");
            modelAndView.addObject("logout", "display: none;");
            modelAndView.addObject("login", "display: block;");
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/rocket-editor", method = RequestMethod.GET)
    public ModelAndView rocketEditor() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/rocket-editor");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/rocket-editor", method = RequestMethod.POST)
    public ModelAndView addNewRocket(@Valid Rocket rocket, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/rocket-editor");
        } else {
            rocketService.saveRocket(rocket);
            modelAndView.addObject("rocket", new Rocket());
            modelAndView.setViewName("admin/rocket-editor");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());

        if (userExists != null) {
            bindingResult.rejectValue("username", "error.username", "There is already a user registered with this username.");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }

}
