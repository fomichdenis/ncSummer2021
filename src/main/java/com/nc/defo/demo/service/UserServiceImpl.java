package com.nc.defo.demo.service;

import com.nc.defo.demo.model.User;
import com.nc.defo.demo.repository.UserRepository;
import com.nc.defo.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    UserRepository repository;



    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserById(Integer id) {
        return repository.findUserById(id);
    }

    @Override
    public User getUserByName(String name) {
        return repository.findUserByName(name);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void addUser(User user) {
        user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
        repository.save(user);
    }
}
