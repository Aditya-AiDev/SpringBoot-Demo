package com.example.demo1.Project1.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Target(ElementType.FIELD)
@Retention (RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {GenderValidator.class} )
public @interface ValidGender {   //////////Custom annotation

    String message() default "Invalid gender !!";

    Class<?>[] groups() default {};
    Class<? extends  Payload> [] payload() default {};



}
