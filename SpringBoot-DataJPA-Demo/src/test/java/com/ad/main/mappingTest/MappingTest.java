package com.ad.main.mappingTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ad.main.entities.Laptop;
import com.ad.main.entities.User;
import com.ad.main.repository.LaptopRepo;
import com.ad.main.repository.UserRepo;

import jakarta.transaction.Transactional;

@SpringBootTest
public class MappingTest {

    @Autowired
    private UserRepo ur;

    @Autowired
    private LaptopRepo lr;

    @Test
    @Transactional
    public void testOneToOne() {

        // ////save laptop /////
        // User user = ur.findById(44).orElseThrow(() -> new RuntimeException("user not found"));
        // Laptop laptop = new Laptop();
        // laptop.setModel("MacBook M5 Pro");
        // laptop.setAbout("This is laptop from Apple.");
        // ///set user by laptop
        // laptop.setUser(user);
        // ////set laptop by user
        // user.setLaptop(laptop);
        // //save laptop
        // lr.save(laptop);
        // System.out.println("laptop added");
        // /////
        // ////getting laptop by user
        // User user = ur.findById(44).orElseThrow(() -> new RuntimeException("user not found"));
        // System.out.println(user.getName());
        // Laptop laptop = user.getLaptop();
        // System.out.println(laptop.getId() + "\t" + laptop.getModel());
        //////
        //
        // ////////// getting user by laptop
        // Laptop laptop = lr.findById(1).orElseThrow();
        // System.out.println(laptop.getModel());
        // User user = laptop.getUser();
        // System.out.println(user.getName());

        ///
        //
        // User user = ur.findById(44).orElseThrow(() -> new RuntimeException("user not found"));
        // System.out.println(user.getName());

        ///
        //
        // Laptop laptop = lr.findById(1).orElseThrow();   
        // System.out.println(laptop.getModel());

        //
        //if we ...Lazy loading... for ..user.. as well as ....laptop...
        ///then we need to use execute this in one ...Transaction.... because jpa close the session after first use of one class.. 
        // or..
        Laptop laptop = lr.findById(1).orElseThrow();
        System.out.println(laptop.getModel());
        ///session close--LazyInitializationException-- 
        // if there is no one transaction so use @Transactional in this class ...or...
        User user = laptop.getUser();
        System.out.println(user.getName());

    }

    @Test
    public void testOneToMany() {

        User user = ur.findById(44).orElseThrow(() -> new RuntimeException("user not found"));
        ////save laptop /////
        Laptop laptop = new Laptop();
        laptop.setModel("MacBook M5 Pro");
        laptop.setAbout("This is laptop from Apple.");

        //
        Laptop laptop2 = new Laptop();
        laptop2.setModel("MacBook Air M5");
        laptop2.setAbout("This is laptop from Apple.");
        ///set user by laptop
        laptop.setUser(user);
        laptop2.setUser(user);

        //if we ...Lazy loading... for ..user.. as well as ....laptop...
        ///then we need to use execute this in one ...Transaction.... because jpa close the session after first use of one class.. 
        // or..
        ///session close--LazyInitializationException-- 
        // if there is no one transaction so use @Transactional in this class 
        // or.....

        ////set laptop by user
        user.getLaptopList().add(laptop);
        user.getLaptopList().add(laptop2);

        // //save user
        ur.save(user);
        System.out.println("laptop list added");
        System.out.println("user updated");

        // /////
        //.......................... Or..........................
        //          by ///JOIN FETCH /////or//@EntityGraph///for session close--LazyInitializationException-- 


    ////////////////////////////////// //////////////// User entity//////////////////////////

                // ////////////////////////////////////////////////
                // @Entity
                // public class User {
                //     @Id
                //     private Integer id;

                //     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
                //     private List<Laptop> laptops = new ArrayList<>();

                //     // getters and setters
                // }


                // //////////////////////////////
                
                ////queries in your ////////////////////UserRepository:

                ///
                // public interface UserRepository extends JpaRepository<User, Integer> {

                //     // 1. Using JOIN FETCH (JPQL)
                //     @Query("SELECT u FROM User u LEFT JOIN FETCH u.laptops WHERE u.id = :id")
                //     Optional<User> findByIdWithLaptops(@Param("id") Integer id);

                //     // 2. Using @EntityGraph (Spring Data JPA)
                //     @EntityGraph(attributePaths = {"laptops"})
                //     Optional<User> findUserById(Integer id);
                // }
                ////////////////////////////////////////////////////
                //////////////////////////////////////////
                ////////////////////////////////////////////////////////////////(Laptop entity)//////////////
                //  
                // 

                
                // @Entity
                // public class Laptop {
                //     @Id
                //     private Integer id;

                //     @ManyToOne(fetch = FetchType.LAZY)
                //     @JoinColumn(name = "user_id")
                //     private User user;

                //     // getters and setters
                // }
                // ///////////////////////////////
                ///////////////////////// LaptopRepository:

                ////////////////
                // public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

                //     // 1. Using JOIN FETCH (JPQL)
                //     @Query("SELECT l FROM Laptop l JOIN FETCH l.user WHERE l.id = :id")
                //     Optional<Laptop> findByIdWithUser(@Param("id") Integer id);

                //     // 2. Using @EntityGraph (Spring Data JPA)
                //     @EntityGraph(attributePaths = {"user"})
                //     Optional<Laptop> findLaptopById(integer id);
                // }



                //////////////////////////// Notes ///////////////////
                // cascade = CascadeType.ALL ///// handles persistence operations across the lifecycle: 
                // when you save, update, or refresh a User, those changes automatically propagate to their Laptop objects.

                // orphanRemoval = true ////// handles disassociation: if you remove a Laptop from user.getLaptops().remove(laptop),
                // JPA will automatically generate a DELETE SQL statement for that specific laptop record in the database.

                //                 Best practice rules for using them together
                // Strictly for Parent-Child relationships (Composition):

                // Good: User -> Laptop (A laptop belongs strictly to a user; if removed from the user, it shouldn't exist).

                // Bad: Laptop -> Brand (If you delete a laptop, you don't want to delete the Brand entity, nor should deleting a laptop orphan a brand).
                
                /////////////////////////////////////////////////////////
                // Only use on @OneToMany or @OneToOne:

                /////////////////////////////////////////////////////////////////////
                // Never use orphanRemoval = true on a @ManyToOne or @ManyToMany mapping.

                /////////////////////////////////////////
                // Be careful with list reassignments:

                // Instead of clearing or reassigning the collection:

                // Java
                // // ❌ AVOID: Can cause JPA tracking issues
                // user.setLaptops(newArrayList);
                // Modify the managed collection directly:

                // Java
                // // ✅ RECOMMENDED
                // user.getLaptops().clear();
                // user.getLaptops().addAll(newArrayList);
        
    }

}
