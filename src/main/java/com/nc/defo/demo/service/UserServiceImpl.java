package com.nc.defo.demo.service;

import com.nc.defo.demo.model.Role;
import com.nc.defo.demo.model.User;
import com.nc.defo.demo.repository.UserRepository;
import com.nc.defo.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserById(Integer id) {
        return repository.findUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void addUser(User user) {
        user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
        user.setRoles(Collections.singleton(new Role(2, "ROLE_USER")));
        repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByUsername(username);
    }
}
