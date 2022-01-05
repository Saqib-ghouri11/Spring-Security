package com.spring.springbootsecurity.impls;

import com.spring.springbootsecurity.dtos.UserDto;
import com.spring.springbootsecurity.entities.User;
import com.spring.springbootsecurity.repos.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepoImpl implements UserRepository {
    List<User> users=new ArrayList();
    {
        users.add(new User(1,"saqib","123456","saqib@example.com"));
        users.add(new User(2,"Ali","123456","ali@example.com"));
    }
    @Override
    public User getById(Integer id) {
        return this.users.stream().filter(user->user.getId().equals(id)).findAny().get();
    }

    @Override
    public List<User> getAll() {
        return users;
    }



    @Override
    public User addUser(UserDto userdto) {
        User user = new User();
        if(userdto!=null){
            userdto.setId(users.get(users.size()-1).getId()+1);
            BeanUtils.copyProperties(userdto,user);
            users.add(user);
        }

        return user;
    }

    @Override
    public User deleteUser(Integer id) {
        User user=this.users.stream().filter(usr->usr.getId().equals(id)).findAny().get();
        if(user!=null){
            this.users.remove(user);
        }
        return user;
    }
}
