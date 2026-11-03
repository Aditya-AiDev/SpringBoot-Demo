package com.ad.oAuthResourceServer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.security.autoconfigure.SecurityProperties.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ad.oAuthResourceServer.dto.UserDto;

@RestController 
@RequestMapping ("/api/v1/users")
public class UserController {

    @GetMapping 
    public List<UserDto> getUsers(){
        List<UserDto> users=new ArrayList<>();
        users.add(new UserDto("John1","Doe1"));
        users.add(new UserDto("John2","Doe2"));
        users.add(new UserDto("John3","Doe3"));
        users.add(new UserDto("John4","Doe4"));
        users.add(new UserDto("John5","Doe5"));

        return users;

    }

    @PostMapping
    public  String createUser(@RequestBody UserDto userDto){
        return "user created";
    } 

}
