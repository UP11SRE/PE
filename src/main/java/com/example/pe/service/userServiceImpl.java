package com.example.pe.service;

import com.example.pe.dao.UserDao;
import com.example.pe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class userServiceImpl implements userService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //List<User>list = new ArrayList<>();


    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public User addUsers(User user){
        //list.add(user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return user;
    }

    @Override
    public User updateUser(User user){
       // list.forEach(e -> {
         //   if (e.getName() == user.getName()){
           // e.setName(user.getName());
            //e.setPassword(user.getPassword());
           // }
        //} );
        userDao.save(user);
        return user;
    }

    //@Override
   // public User loginUser(User user) {
     //   return null;
    //}

    // @Override
    //public User loginUser(User user){
      //  list = this.list.stream().filter(e->e.getId()!=user) collect(Collecters.tolist());
    //}


}
