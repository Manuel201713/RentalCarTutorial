package com.rentcar.webapp.controller;

import com.rentcar.webapp.Exception.MasterException;
import com.rentcar.webapp.entity.User;
import com.rentcar.webapp.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(Model model){

        List<User> users = userService.all();
        model.addAttribute("Users",users);
        model.addAttribute("Titolo", "Ricerca Utenti");
        model.addAttribute("Titolo2","Risultati Ricerca");
        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User insertUser(@RequestBody User user, HttpServletResponse response) {

        try {
            return userService.create(user);
        } catch (Exception e) {
            throw e;
        }
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User updateUser(@RequestBody User user, HttpServletResponse response) {

        try {
            return userService.update(user);
        } catch (MasterException e) {
            throw e;
        }
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUser(@RequestBody User user, HttpServletResponse response) {

        try {
            userService.delete(user);
        } catch (MasterException e) {
            throw e;
        }
    }
}
