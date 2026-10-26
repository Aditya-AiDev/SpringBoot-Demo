package com.ad.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ad.main.dao.CategoryDao;
import com.ad.main.dao.CourseDao;
import com.ad.main.entities.courseCategoryJoin;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private CategoryDao cDao;

    @Autowired
    private CourseDao csDao;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        /////////////////////// category table //////

        // Category ct=new Category();
        // ct.setId(105);
        // ct.setTitle("Offline");
        // ct.setDescription("this is Offline category");
        // /////////////////////////save/////////
        // Category savedCategory=cDao.save(ct);
        // System.out.println("category saved with id:" +savedCategory.getId());
        // //////////////////////////////////////////// getAll////
        // List<Category> ctList=cDao.getAll();
        // for(Category ct:ctList){
        // 	System.out.println(ct.getId());
        // }
        // //////////////////////////////////////get///
        // Category ct=cDao.get(102);
        // System.out.println(ct.getDescription());
        // //////////////////////////Delete
        // cDao.delete(101);
        ////////////////////////// Search
		// String title="Trending"; 
		// List<Category> list=cDao.search(title);
		// for(Category ct:list){
		// 	System.out.println(ct.getId());
		// 	System.out.println(ct.getDescription());
		// }
		

		// //////partial search by title
		// String title="line"; 
		// Category ct=cDao.partialSearchByTitle(title);
		
		// System.out.println(ct.getId());
		// System.out.println(ct.getTitle());
		// System.out.println(ct.getDescription());
		


		// ///// partial search by title and description
		// //String item="Category";  ////sql query for passing value is not case sensitive
		// String item="line"; 
		// List<Category> list=cDao.partialSearchByTitleAndDesCription(item);
		// for(Category ct:list){
		// 	System.out.println(ct.getId());
		// 	System.out.println(ct.getTitle());
		// 	System.out.println(ct.getDescription());
		// }
		

		// ////////////////////// count the rows in table /////
		// int count=cDao.count();
		// System.out.println("total rows:"+count);


		/////////////////////////////////////////////////////////////////////////////////////////////
		////Course table /////

		// Course course = new Course();
        // course.setCourseId(23);
        // course.setTitle("Spring Boot course-Live");
        // course.setDescription("this is best trending live course");
        // course.setPrice(10999);
        // course.setCategoryId(102);

        // //////save///
		// csDao.save(course);


		// /////get single course
		// Course cs = csDao.get(22);
        // System.out.println(cs.getTitle());

		// ///// get all courses
		// List<Course> cs = csDao.getAll();
        // for (Course ele : cs) {
        //     System.out.println(ele.getCourseId());
        //     System.out.println(ele.getTitle());
        //     System.out.println(ele.getDescription());
        //     System.out.println(ele.getPrice());
        //     System.out.println(ele.getCategoryId());

        // }

        // /////// get course by categoryId
        // List<Course> cs = csDao.getCourseByCategory(101);
        // for (Course ele : cs) {
        //     System.out.println(ele.getCourseId());
        //     System.out.println(ele.getTitle());
        //     System.out.println(ele.getDescription());
        //     System.out.println(ele.getPrice());
        //     System.out.println(ele.getCategoryId());

        // }

        


        ////// Join ///////////////
        List<courseCategoryJoin> ccdList = csDao.courseCatJoinData();
        for (courseCategoryJoin ele : ccdList) {
            System.out.println(ele.getCtTitle() + " and " + ele.getCsTitle());
        }

    }

}
