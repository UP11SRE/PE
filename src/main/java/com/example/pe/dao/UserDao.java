package com.example.pe.dao;

import com.example.pe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    User findByName(String name);
}
