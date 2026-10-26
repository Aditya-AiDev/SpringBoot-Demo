package com.ad.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ad.foodie.entity.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, String> {

}
