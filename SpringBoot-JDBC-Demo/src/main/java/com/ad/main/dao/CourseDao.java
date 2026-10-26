package com.ad.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ad.main.entities.Course;
import com.ad.main.entities.courseCategoryJoin;

@Repository
public class CourseDao {

    @Autowired
    private JdbcTemplate jt;

    ////create course
    public Course save(Course course) {

        String query = "insert into courses(courseId, title, description, price, category_Id) values(?,?,?,?,?)";

        int row = jt.update(query,
                course.getCourseId(),
                course.getTitle(),
                course.getDescription(),
                course.getPrice(),
                course.getCategoryId()
        );

        System.out.println(row + " rows effected");

        return course;
    }

    //// get all course

    public List<Course> getAll() {

        String query = "select * from courses";

        List<Course> courses1 = jt.query(query,
                (rs, rowNum) -> {
                    ////Row mapper by functional interface lambda
                                            Course course = new Course();
                    course.setCourseId(rs.getInt("courseId"));
                    course.setTitle(rs.getString("title"));
                    course.setDescription(rs.getString("description"));
                    course.setPrice(rs.getInt("price"));
                    course.setCategoryId(rs.getInt("category_Id"));

                    return course;
                }
        );

        return courses1;
    }

    ///get single course

    public Course get(int courseId) {

        String query = "select * from courses where courseId=?";

        Course course1 = jt.queryForObject(query,
                (rs, rowNum) -> {
                    ////Row mapper by functional interface lambda
                                            Course c = new Course();
                    c.setCourseId(rs.getInt("courseId"));
                    c.setTitle(rs.getString("title"));
                    c.setDescription(rs.getString("description"));
                    c.setPrice(rs.getInt("price"));
                    c.setCategoryId(rs.getInt("category_Id"));

                    return c;
                },
                courseId
        );

        return course1;
    }

    ////update course
    public Course update(int courseId, Course newCourse) {
        String query = "update courses set title=?, description=? where courseId=?";
        int update = jt.update(query,
                newCourse.getTitle(),
                newCourse.getDescription(),
                courseId
        );

        System.out.println(update + " effected");
        newCourse.setCourseId(courseId);
        return newCourse;

    }

    ////// delete course

    public void delete(int courseId) {
        String query = "delete from courses where courseId=?";
        jt.update(query, courseId);
        System.out.println("deleted" + courseId);
    }

    ///// get course by categoryId
    public List<Course> getCourseByCategory(int categoryId) {

        String query = "select * from courses where category_Id=?";

        List<Course> courses1 = jt.query(query,
                (rs, rowNum) -> {
                    ////Row mapper by functional interface lambda
                                            Course course = new Course();
                    course.setCourseId(rs.getInt("courseId"));
                    course.setTitle(rs.getString("title"));
                    course.setDescription(rs.getString("description"));
                    course.setPrice(rs.getInt("price"));
                    course.setCategoryId(rs.getInt("category_Id"));

                    return course;
                },
                categoryId
        );

        return courses1;
    }

    /////////////// Join query/// for relational data retrieval

    public List<courseCategoryJoin> courseCatJoinData() {
        String query = "select ct.title as ctTitle, ct.description as ctDesc, cs.title as csTitle, cs.description as csDesc, cs.price as csPrice \n"
                + "from categories as ct \n"
                + "inner join courses as cs \n"
                + "on ct.id=cs.category_id";

        List<courseCategoryJoin> ccj1 = jt.query(query,
                (rs, rowNum) -> {
                    courseCategoryJoin ccj = new courseCategoryJoin();
                    ccj.setCtTitle(rs.getString("ctTitle"));
                    ccj.setCtDesc(rs.getString("ctDesc"));
                    ccj.setCsTitle(rs.getString("csTitle"));
                    ccj.setCsDesc(rs.getString("csDesc"));
                    ccj.setCsPrice(rs.getInt("csPrice"));
                    return ccj;
                }
        );

        return ccj1;
    }

}
