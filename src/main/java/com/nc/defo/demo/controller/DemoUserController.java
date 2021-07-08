package com.nc.defo.demo.controller;

import com.nc.defo.demo.model.User;
import com.nc.defo.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoUserController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/hello1")
    public String helloWorld1() {
        return "Hello world 1";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
