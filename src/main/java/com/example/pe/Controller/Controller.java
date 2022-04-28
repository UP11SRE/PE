package com.example.pe.Controller;

import com.example.pe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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




    @GetMapping("/login")
    public String login(Model model, String error, String logout) {


        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        //if (logout != null)
          //  model.addAttribute("message", "You have been logged out successfully.");
        return "login successful";
    }




    @GetMapping("/logout1")
    public String logoutDo(HttpServletRequest request, HttpServletResponse response){
        HttpSession session= request.getSession(false);
        SecurityContextHolder.clearContext();
        session= request.getSession(false);
        System.out.println("session = " + session.getId());
        if(session != null)
        {

            session.invalidate();
            System.out.println("session1 = " + session.getId());
        }
        for(Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }

        return "logout";
    }






    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        return this.userService.addUsers(user);
    }


    @PutMapping("/adduser")
    public User updateUser(@RequestBody User user ){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id) {
            userService.deleteUser(id);

    }





}




