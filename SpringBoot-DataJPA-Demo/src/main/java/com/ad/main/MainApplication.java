package com.ad.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ad.main.repository.DepartmentRepo;
import com.ad.main.repository.UserRepo;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private UserRepo ur;

    @Autowired
    private DepartmentRepo dr;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



    /////Save user//////////////////////////////////////

		// User user = new User();
        // user.setUserId(22);
        // user.setName("Verma");
        // user.setAge(23);
        // user.setActive(true);

        // User saveUser = ur.save(user);
        // System.out.println(saveUser.getName());

		// Department depart = new Department();
        // // depart.setDepartmentId(); do not need provide the value because it is automatically updated by spring  
        // depart.setName("CSE");
        // depart.setAbout("department for teach sector");
        // depart.setDepartmentCode("CSE37");

        // Department saveDepart = dr.save(depart);
        // System.out.println(saveDepart.getName());


		////////////////////////////////// find all /////////////

		// List<User> all = ur.findAll();
        // for (User ele : all) {
        //     System.out.println(ele.getName());
        // }

    }

}
