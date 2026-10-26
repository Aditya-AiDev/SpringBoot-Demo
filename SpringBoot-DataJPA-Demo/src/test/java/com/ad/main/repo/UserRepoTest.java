package com.ad.main.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ad.main.entities.User;
import com.ad.main.repository.UserRepo;

@SpringBootTest
public class UserRepoTest {

    @Autowired
    private UserRepo ur;

    @Test
    public void repoTest() {


        // //////////////////////////////// findByEmailOrderByNameAsc ///
        // Optional<User> userOp = ur.findByEmailOrderByNameAsc("adityavermabe@gamil.com");
        // // userOp.ifPresent(user -> {
        // //     System.out.println(user.getUserId());
        // //     System.out.println(user.getName());
        // //     System.out.println(user.getEmail());
        // // });
        // // userOp.ifPresentOrElse(user -> {
        // //     System.out.println(user.getUserId());
        // //     System.out.println(user.getName());
        // //     System.out.println(user.getEmail());
        // // },
        // //         () -> {
        // //             System.out.println("user not fount");
        // //         }
        // // );
        // User user = userOp.orElseThrow(() -> new RuntimeException("user not found"));
        // System.out.println(user.getUserId());
        // System.out.println(user.getName());
        // System.out.println(user.getEmail());
        // ///////////////////////////// countByName ////////////
        // int i = ur.countByName("Aadi ");
        // System.out.println(i); ///1
        // int i1 = ur.countByNameIgnoreCase("Aadi");
        // System.out.println(i1); ///0 because case is ignored not white space
        ////////////findByNameContaining//////////////////

        List<User> list = ur.findByNameContaining("i");
        list.forEach((user) -> {
            System.out.println(user.getName());

        });
    }

    @Test     
    public void test(){
        List<User> list=ur.getUserByCountry("India");
        list.forEach((user) -> {
            System.out.println(user.getName());

        });
        
    }

}
