package com.example.demo1.Project1.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Project1.Beans.User;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    //org.slf4j.Logger interface
    private Logger log = LoggerFactory.getLogger(AuthController.class);

    //////////////////////////////////////
    //////Request Body example ///////////


    /////////////
    //login
    ///

    //if you want to receive ..json Object..or you do not know..what type of json datatype..  but you have java List because java list wants json array..so.. use ...custom class.. or ..java map...  
    // @RequestMapping("/login")
    // public List<String> login(@RequestBody List<String> list) {

    //     log.info("List : {}", list);
    //     return list;

    // }

    ///
    // @RequestMapping(value="/login",method=RequestMethod.POST)
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> map,
            @RequestHeader("User-Agent") String agent,
            @RequestHeader("Authorization") String token
    ) {

        log.info("Map : {}", map);

        log.info("user agent : {} ", agent);
        log.info("user token : {} ", token);
        return map;

    }

    ////////////////////
    //sign up
    ///
    // @RequestMapping("/signup")
    // @GetMapping("/signup")
    @PostMapping("/signup")
    public String signup(@Valid @RequestBody User userData) {

        ///S.o.pln. --> print on console

        ///for more log --> by Logging Framework --> inbuilt in Spring Boot -->
        // gives --> console access , file, change printing form, error, debug, trace, info..............
        log.info("user name : {}", userData.getName());
        log.info("password : {}", userData.getPassword());
        log.info("user email : {}", userData.getEmail());
        log.info("user age : {}", userData.getAge());
        return "we got data";

    }


    @GetMapping("/logg")
    public List<String> logg(@RequestBody List<String> list)  {

        // String test=null;
        // test.length();

        log.info("List : {}", list);
        return list;

    }

    // ///Local --Exception Handling /////////////////////////////////////////////////////////////////////////


    // //Exception handling method :- for this controller for NullPointerException
    /////////
    // @ExceptionHandler(NullPointerException.class)
    // public String handleNullPointer(NullPointerException ex){

    //     log.error(ex.getMessage());

    //     ex.printStackTrace();
    //     return ex.getMessage();
    // }

    // ///Local
    // //Exception handling method :- for this controller for MethodArgumentNotValidException--hibernate validation ---if we not provide value for field while parsing ----
    /////////////
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

    //     log.error(ex.getMessage());


    //     ex.printStackTrace();
    //     // return ex.getMessage();
    //     return "your input data not valid ";
    // }

  

}
