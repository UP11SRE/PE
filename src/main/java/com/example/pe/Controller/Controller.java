package com.example.pe.Controller;

import com.example.pe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.stereotype.Controller
@RestController
public class Controller {

    @Autowired
    private com.example.pe.service.userService userService;

    @GetMapping("/user")
    public String user(){
String i ="Hellos";
        return "this is a home page";

    }

    @GetMapping("/users")
    public List<User> getUsers(){

        return this.userService.getUsers();

    }

   // @PostMapping("/login")
    //public String login(){
       // return "Login sucessfully";
    //}

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

       // if (logout != null)
         //   model.addAttribute("message", "You have been logged out successfully.");

        return "login sucessfully";
    }





    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        return this.userService.addUsers(user);
    }


    @PutMapping("/adduser")
    public User updateUser(@RequestBody User user ){
        return this.userService.updateUser(user);
    }

    //@PostMapping("/users")
    //public ResponseEntity<Loginvalid>loginUser(@RequestBody User user){
      //  return this.userService.loginUser(user);
    //}



}




