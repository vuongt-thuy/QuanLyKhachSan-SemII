/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs) {
        try {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ProductMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
