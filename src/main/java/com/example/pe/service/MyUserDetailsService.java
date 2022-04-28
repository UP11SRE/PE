package com.example.pe.service;

import com.example.pe.dao.UserDao;
import com.example.pe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService{

    @Autowired
     UserDao dao;


    //@Autowired private userPrincipal userPrincipal;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException, DataAccessException {


        User user = dao.findByName(name);
        if (name == null)
               throw new UsernameNotFoundException("user 404");


      return new userPrincipal(user);

    }

}
