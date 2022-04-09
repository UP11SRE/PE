package com.example.pe.Controller;

import com.example.pe.entity.User;
import com.example.pe.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@org.springframework.stereotype.Controller
@RestController
public class Controller {


    private com.example.pe.service.userService userService;

    @GetMapping("/user")
    public String user(){

        return "this is a home page";

    }

    @GetMapping("/users")
    public List<User> getUsers(){

        return this.userService.getUsers();

    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return this.userService.addUsers(user);
    }

}
