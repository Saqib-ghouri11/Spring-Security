package com.spring.springbootsecurity.adapters;

import com.spring.springbootsecurity.entities.User;

import java.util.List;

public interface UserDao {
    User getById(Integer id);
    List<User> getAll();
}
