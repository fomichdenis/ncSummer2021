package com.nc.defo.demo.service.interfaces;

import com.nc.defo.demo.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Integer id);

    User getUserByName(String name);

    List<User> getAllUsers();

    void addUser(User user);

}
