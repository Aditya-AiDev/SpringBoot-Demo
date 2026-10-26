package com.ad.foodie.service;

import java.util.List;

import com.ad.foodie.entity.Restaurant;
import com.ad.foodie.entity.User;

public interface UserService {

    ///user and restaurant
    User saveUser(User user);

    User updateNameAndEmail(User newUser, String userId, Restaurant newRes, String resId);

    // User and roleEntity
    List<User> saveUserRole(List<User> users);
}
