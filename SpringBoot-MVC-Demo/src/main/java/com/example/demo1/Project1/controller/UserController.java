package com.example.demo1.Project1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Project1.Beans.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/player-list")
    public List<String> players() {
        List<String> list = new ArrayList<>();
        list.add("Aditya");
        list.add("VIRAT");
        list.add("Rohit");
        list.add("Amit");
        list.add("Ayush");
        list.add("Bumrah");
        return list;
    }

    @RequestMapping("/get-user")
    public User getUser() {

        User user = new User();
       
        user.setName("Aditya");
        user.setEmail("abc@gamil.com");

        

        return user;

    }

    ///URI path variable
    @RequestMapping("/wish/{message}/for/{userName}")
    public String wish(@PathVariable("message") String userMessage, @PathVariable(required = false) String userName) {
        return "wishing " + userMessage + " for " + userName;

    }

    ///query parameter
    @RequestMapping("/wish")
    public String wishQuery(@RequestParam(value = "message", required = false) String userMessage, @RequestParam(required = false) String userName) {
        return "wishing " + userMessage + " for " + userName;

    }

    


}
