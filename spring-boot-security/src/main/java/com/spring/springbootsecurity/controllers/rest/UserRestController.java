package com.spring.springbootsecurity.controllers.rest;

import com.spring.springbootsecurity.dtos.UserDto;
import com.spring.springbootsecurity.entities.User;
import com.spring.springbootsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
//this annotation is used for annotation role based authentication it you are not using antMatchers in SpringSecurity configuration class
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserRestController {
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

    @PostMapping("/add")
    public User addUser(@RequestBody @Valid UserDto userDto){
        User user=null;
        try {
          user=  userService.addUser(userDto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @DeleteMapping("delete/{id}")
    //this annotation is used for annotation role based authentication it you are not using antMatchers in SpringSecurity configuration class
    //@PreAuthorize("hasRole('ADMIN')")
    public User deleteUser(@PathVariable("id")Integer id){
        return userService.deleteUser(id);
    }

    //this is to alert user about validations
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

}
