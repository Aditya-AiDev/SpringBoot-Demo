package com.example.demo1.Project1.Beans;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import com.example.demo1.Project1.utils.ValidGender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class User {

    // Common Causes of UnexpectedTypeException
    // 

    // Using numeric annotations on Strings: Applying @Min, @Max, @Positive, or @Negative to a String field instead of an Integer, Long, or BigDecimal.

    // Using size/length annotations on numbers: Applying @Size or @Length to an Integer or Long instead of a String, Collection, Map, or array.

    // Using @NotBlank or @NotEmpty on non-string types: These annotations are meant for CharSequence (Strings), Collection, Map, or arrays. Using them on custom objects or primitives causes errors.

    @NotEmpty(message = "name is required !!")
    @Size(min = 3, max = 20, message = "name must be between 2 and 20 characters")
    //contains at least one capital letter, at least one digit, and at least one special character
    @Pattern (regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).+$",message = "contains at least one capital letter, at least one digit, and at least one special character")
    private String name;

    @NotNull 
    @Min(value = 18, message = "minimum required value is 18")
    @Max(value = 99, message = "minimum required value is 99")
    private int age;

    @Email(message = "Invalid email!!")
    private String email;

    @NotEmpty(message = "password is required !! ")
    private String password;

    @ValidGender(message = "only male or female allowed !!")   ////Custom Validator ---Annotation
    private String gender;

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //private List<String> address;
    //private String phoneNumber;
}
