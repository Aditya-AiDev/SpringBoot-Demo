package com.ad.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ad.foodie.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}
