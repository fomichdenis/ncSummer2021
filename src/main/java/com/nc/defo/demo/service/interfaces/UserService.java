package com.nc.defo.demo.service.interfaces;

import com.nc.defo.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User getUserById(Integer id);

    User getUserByUsername(String name);

    List<User> getAllUsers();

    void addUser(User user);

}
