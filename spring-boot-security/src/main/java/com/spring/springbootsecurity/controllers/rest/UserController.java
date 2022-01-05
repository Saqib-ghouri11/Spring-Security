package com.spring.springbootsecurity.controllers.rest;

import com.spring.springbootsecurity.entities.User;
import com.spring.springbootsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }


}
