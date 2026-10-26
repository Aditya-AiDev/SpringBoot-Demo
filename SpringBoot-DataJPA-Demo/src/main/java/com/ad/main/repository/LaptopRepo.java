package com.ad.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ad.main.entities.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer> {

}
