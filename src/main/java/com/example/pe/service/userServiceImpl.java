package com.example.pe.service;

import com.example.pe.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class userServiceImpl implements userService{

    List<User>list;

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User addUsers(User user){
        list.add(user);
        return user;
    }
}
