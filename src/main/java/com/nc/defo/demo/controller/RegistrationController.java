package com.nc.defo.demo.controller;

import com.nc.defo.demo.model.User;
import com.nc.defo.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

}
