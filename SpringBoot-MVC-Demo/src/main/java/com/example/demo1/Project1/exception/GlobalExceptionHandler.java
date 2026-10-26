package com.example.demo1.Project1.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.UnexpectedTypeException;

// @RestController 
// @ControllerAdvice
@RestControllerAdvice  
public class GlobalExceptionHandler {
    private Logger log=LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointer(NullPointerException ex){

        log.error(ex.getMessage());

        ex.printStackTrace();
        return ex.getMessage();
    }

    

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        Map<String,String> errMap=new HashMap<>();

        
        ///Fetch all errors list from BindingResult
        List<ObjectError> allErrors= ex.getBindingResult().getAllErrors();

        //iterate all errors and get the error to map
        allErrors.forEach( error ->{
            //error : we have to fetch the field
            String fieldName=((FieldError) error ).getField();
            String msg=error.getDefaultMessage();
            errMap.put(fieldName,msg);

        });

        log.info(errMap.toString());
        return errMap;
    }

    
}
