package com.example.demo1.Project1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HomeController {

    // @Autowired
    // public HomeController(){
    //     System.out.println("contoller bean");
    // }

    @GetMapping("/ex")
    public List<String> logg(@RequestBody List<String> list)  {

        // String test=null;
        // test.length();

       
        return list;

    }
}
