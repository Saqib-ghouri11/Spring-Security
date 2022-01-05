package com.spring.springbootsecurity.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pub")
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Welcome to Spring Security home.";
    }
    @GetMapping("/login")
    public String login(){
        return "Welcome to Spring Security login.";
    }
    @GetMapping("/register")
    public String register(){
        return "Welcome to Spring Security register.";
    }
}
