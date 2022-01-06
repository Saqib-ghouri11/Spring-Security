package com.spring.springbootsecurity.services;

import com.spring.springbootsecurity.dtos.UserDto;
import com.spring.springbootsecurity.entities.User;
import com.spring.springbootsecurity.repos.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    //this method connects database users with spring security provided UserDetailsService interface
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("Email invalid");
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRole()).build();
    }

    public List<User> getAllUsers(){
return        userRepository.findAll();
    }
    public User getUserById(Integer id){
        return userRepository.findById(id).get();
    }
    public User addUser(UserDto userDto){
        User user=new User();
        if(userDto!=null){
            BeanUtils.copyProperties(userDto,user);
            userRepository.save(user);
        }
        return user;
    }

    public User deleteUser(Integer id){
        User user=userRepository.findById(id).get();
        if(user!=null){

            userRepository.delete(user);
        }
        return user;
    }
}
