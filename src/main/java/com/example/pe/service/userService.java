package com.example.pe.service;

import com.example.pe.entity.User;

import java.util.List;

public interface userService {

    public List<User> getUsers();
    public User addUsers(User user);


    public User updateUser(User user);

    public void deleteUser(long parseLong);


}
