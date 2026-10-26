package com.ad.main.serviceCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.main.entities.User;
import com.ad.main.repository.UserRepo;

@Service
public class UserServiceCRUD {

    @Autowired
    private UserRepo ur;

    /////Save user////
    public User save(User user) {
        return ur.save(user);
    }

    ///// Get User ////
    public User get(int userId) {
        return ur.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }
}
