package com.example.pe.service;

import java.util.List;
import com.example.pe.entity.User;

public interface userService {

    public List<User> getUsers();
    public User addUsers(User user);


    public User updateUser(User user);

    //public User loginUser(User user);

    //public User loginUser(User user);
}
