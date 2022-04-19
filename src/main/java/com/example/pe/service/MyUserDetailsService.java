package com.example.pe.service;

import com.example.pe.dao.UserDao;
import com.example.pe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService  implements UserDetailsService{

    @Autowired
    private UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
        User user = dao.findByUsername(name);
        if (name == null)
                throw new UsernameNotFoundException("user 404");



        return new userPrincipal(user);
    }

}
