package com.nc.defo.demo.repository;

import com.nc.defo.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);
    User findUserByName(String name);

}
