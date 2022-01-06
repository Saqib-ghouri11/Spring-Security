package com.spring.springbootsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/signin")
    public String login(){
        return "login.html";
    }
    @GetMapping("/home")
    public String home(){
        return "home.html";
    }

}
