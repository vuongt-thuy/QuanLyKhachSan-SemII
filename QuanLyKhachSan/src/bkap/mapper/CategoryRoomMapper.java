/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.CategoryRoom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class CategoryRoomMapper implements RowMapper<CategoryRoom> {

    @Override
    public CategoryRoom mapRow(ResultSet rs) {
        try {
            CategoryRoom c = new CategoryRoom();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setPrice(rs.getFloat("price"));

            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryRoomMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
