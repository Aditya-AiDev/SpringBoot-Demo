package com.example.demo1.Project1.utils;



import java.util.logging.Logger;

import com.example.demo1.Project1.exception.GlobalExceptionHandler;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidator  implements ConstraintValidator<ValidGender,String>{

    private Logger log=Logger.getLogger(this.getClass().getName());

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        //
        if(value==null || value.isEmpty()){
            log.warning("Invalid Gender String");
            return false;

        }
        //
        if(value.toLowerCase().equals("male") || value.toLowerCase().equals("female")){
            return true;
        }

        return false;
    }

}
