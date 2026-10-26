package com.ad.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ad.main.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
