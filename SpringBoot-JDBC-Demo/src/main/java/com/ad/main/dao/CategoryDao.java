package com.ad.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ad.main.entities.Category;

import jakarta.annotation.PostConstruct;
import utils.CategoryRowMapper;

@Repository
public class CategoryDao {

    @Autowired
    private JdbcTemplate jt;


    /////Create Table
    @PostConstruct
    public void init(){
        String createTableQuery="CREATE TABLE IF NOT EXISTS categories(id int primary key, title varchar(100) not null, description varchar(500) ) ";
        jt.update(createTableQuery);
        System.out.println("table created");
    }



    // save category
    public Category save(Category ct){
        ///parametrized query
        String query="insert into categories(id,title,description) values(?,?,?)";
        int  rows=jt.update(query,
                            ct.getId(),
                            ct.getTitle(),
                            ct.getDescription()
                            );
        System.out.println(rows +"effected");

        return ct;

    } 



    ///update category
    public Category update(int categoryId ,Category newCt){
        ///parametrized query
        String query="update categories set title=?, description=? where id=?";
        int  update=jt.update(query,
                            newCt.getTitle(),
                            newCt.getDescription(),
                            categoryId
                            );
        System.out.println(update +"effected");
        newCt.setId(categoryId);
        return newCt;

    } 




    ////get single category by id
    public Category get(int ID){
        String query="select * from categories where id=?";
        ///////////////////////// These method use row mapper indirectly when DB column name and table field name same////////////
        // return jt.queryForObject(query,Category.class, ID);

        ///////////////////////// This method use row mapper directly when DB column name and table field name not same////////////
        return jt.queryForObject(query, new CategoryRowMapper(), ID);
    }

    ///Delete category

    public void delete(int ID){
        String query="delete from categories where id=?";

        jt.update(query, ID);
        System.out.println("deleted"+ID);
    }



    /// get all category
    public List<Category> getAll(){
        String query="select * from categories";
        
        ///////////////////////// These method use row mapper indirectly when DB column name and table field name same////////////
       // List<Map<String,Object>> data =jt.queryForList(query);
      //  List<Category> categories=jt.queryForList(query, Category.class);

        ///////////////////////// This method use row mapper directly when DB column name and table field name not same////////////
       List<Category> categories = jt.query(query, new CategoryRowMapper());

        
       return categories;


    }



    ////// search/////////////
    ////// ................Exact match search ......................by title /////
    public List<Category> search(String title){
        String query="select * from categories where title=?";

        List<Category> categories=jt.query(query,new CategoryRowMapper(), title);

        return categories;

    }


    /////////////////////// count rows//////
    public int count(){
        String query="select count(*) from categories";
       int count = jt.queryForObject(query, Integer.class);

        return count;

    }


    ////// categoryByTitle ////////
    ////// ............Partial match search.............. by title 
    ///// partial search return mostly ....multiple search  if return is ..list.. so we use like || % ....//// 
    ////// and if we want ..single obj ...then like : ..limit 1//////

    public Category partialSearchByTitle(String title){
        
        String query="select * from categories where title like ? limit 1";

        Category ct=jt.queryForObject(query,new CategoryRowMapper(), "%"+title+"%");

        return ct;
    }



    ////// searchByTitleAndDescription /////
    ////// ............Partial match search.............. by title or description
    public List<Category> partialSearchByTitleAndDesCription(String item){
        String query = "SELECT * FROM categories WHERE title LIKE ? OR description LIKE ?";
        List<Category> ct=jt.query(query,new CategoryRowMapper(),"%"+item+"%","%"+item+"%");

        return ct;
    }




    

}
