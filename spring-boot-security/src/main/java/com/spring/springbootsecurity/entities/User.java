package com.spring.springbootsecurity.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Component
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;

}
