package com.ad.foodie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.foodie.entity.Restaurant;
import com.ad.foodie.entity.User;
import com.ad.foodie.repository.RestaurantRepo;
import com.ad.foodie.repository.RoleEntityRepo;
import com.ad.foodie.repository.UserRepo;
import com.ad.foodie.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo ur;
    private final RestaurantRepo rr;
    private final RoleEntityRepo rer;

    @Autowired
    public UserServiceImpl(UserRepo ur, RestaurantRepo rr, RoleEntityRepo rer) {
        this.ur = ur;
        this.rr = rr;
        this.rer = rer;
    }

    @Override
    public User saveUser(User user) {

        User save = ur.save(user);
        return save;
    }

    @Transactional
    @Override
    public User updateNameAndEmail(User newUser, String userId, Restaurant newRes, String resId) {
        //get User
        User oldUser = ur.findById(userId).orElseThrow(() -> new RuntimeException("User not found: " + userId));
        //set name by newUser in oldUser
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setAddress(newUser.getAddress());

        //get restaurant
        Restaurant oldRes = rr.findById(resId).orElseThrow(() -> new RuntimeException("User not found: " + resId));

        ///set new restaurant
        oldRes.setName(newRes.getName());
        oldRes.setAddress(newRes.getAddress());

        oldRes.setUser(oldUser);
        if (!oldUser.getRestaurants().contains(oldRes)) {  //check for redundant restaurant
            oldUser.getRestaurants().add(oldRes);
        }

        User save = ur.save(oldUser);
        return save;

    }

    @Override
    public List<User> saveUserRole(List<User> users) {
        List<User> save = ur.saveAll(users);
        return save;
    }

}
