package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ad.main.entities.Category;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {

        Category ct=new Category();
        ct.setId(rs.getInt("id"));
        ct.setTitle(rs.getString("title"));
        ct.setDescription(rs.getString("description"));

        return ct;
    }


}
