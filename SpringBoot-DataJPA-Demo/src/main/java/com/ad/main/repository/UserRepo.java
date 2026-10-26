package com.ad.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ad.main.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    /////////////////////////// JPA have some predefine methods but for custom method --if we custom implemented methods 
    //we have two types:
    /////////////////////
    ////  1. Query Methods :
    // return type findBy<property>(T value)    .............T is type...

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailOrderByNameAsc(String email);

    List<User> findByNameIgnoreCase(String name);

    List<User> findByNameAndEmailIgnoreCase(String name, String email);

    List<User> findByNameOrEmail(String name, String email);

    int countByName(String name);

    int countByNameIgnoreCase(String name);

    boolean existsByEmail(String email);

    List<User> findByNameContaining(String nameKeyword);

    List<User> findByNameLike(String pattern);

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    /////2. Manual defined query

    @Query(value = "select * from jpa_user", nativeQuery = true)
    public List<User> getUsers();

    @NativeQuery(value = "select * from jpa_user where email=:email")
    public List<User> getUserByEmail(@Param("email") String email);

    @NativeQuery(value = "select * from jpa_user where email=:email and name=:name")
    public List<User> getUserByEmailAndName(@Param("name") String name, @Param("email") String email);

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////
    ///// Manual defined query is making the programmer DB dependent so we are using HQL/JPQL

    ////HQL/JPQL

    @Query("select u from User u where u.email=:email and u.name=:name")
    public List<User> getUser1(@Param("email") String name, @Param("email") String email);

    @Query("select u from User u where u.address.country=:country")
    public List<User> getUserByCountry(@Param("country") String country);

}
