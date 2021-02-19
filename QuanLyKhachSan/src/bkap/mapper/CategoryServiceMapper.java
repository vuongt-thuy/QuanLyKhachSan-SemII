/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.CategoryService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class CategoryServiceMapper implements RowMapper<CategoryService> {

    @Override
    public CategoryService mapRow(ResultSet rs) {
        try {
            CategoryService c = new CategoryService();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
