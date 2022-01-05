package com.spring.springbootsecurity.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;

}
