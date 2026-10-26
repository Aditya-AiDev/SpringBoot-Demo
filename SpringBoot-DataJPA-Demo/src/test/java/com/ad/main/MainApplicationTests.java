package com.ad.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ad.main.dto.UserType;
import com.ad.main.entities.Address;
import com.ad.main.entities.User;
import com.ad.main.serviceCRUD.UserServiceCRUD;

@SpringBootTest
class MainApplicationTests {

    @Autowired
    private UserServiceCRUD usc;

    @Test
    void saveTestUser() {

        User user = new User();
        user.setUserId(55);
        user.setName("Ayush ");
        user.setEmail("Ayushvermabe@gamil.com");
        user.setAge(17);
        user.setActive(true);
        user.setType(UserType.STUDENT);

        Address addr = new Address();
        addr.setStreet("25 Gomti Nagar Lucknow");
        addr.setCountry("India");
        addr.setPinCode("270001");

        user.setAddress(addr);

        User save = usc.save(user);
        System.out.println(save.getName());

    }

    @Test
    void getTestUser() {

        User user = usc.get(22);
        System.out.println(user.getName());
    }

}
