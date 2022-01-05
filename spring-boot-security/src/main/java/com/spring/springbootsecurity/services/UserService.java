package com.spring.springbootsecurity.services;

import com.spring.springbootsecurity.dtos.UserDto;
import com.spring.springbootsecurity.entities.User;
import com.spring.springbootsecurity.repos.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.getAll();
    }

    public User getUserById(Integer id){
        return userRepository.getById(id);
    }

    public User addUser(UserDto userDto){
        User user = new User();
        if(userDto!=null) {
            BeanUtils.copyProperties(userDto, user);
            userRepository.addUser(userDto);
        }
         return user;
    }

    public User deleteUser(Integer id){
        return userRepository.deleteUser(id);
    }
}
