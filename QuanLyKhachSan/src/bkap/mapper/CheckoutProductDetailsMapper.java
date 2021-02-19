/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.CheckoutProductDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class CheckoutProductDetailsMapper implements RowMapper<CheckoutProductDetails>{

    @Override
    public CheckoutProductDetails mapRow(ResultSet rs) {
        try {
            CheckoutProductDetails c = new CheckoutProductDetails();
            c.setModel(rs.getString("model"));
            c.setProId(rs.getInt("proId"));
            c.setRoomId(rs.getInt("roomId"));
            c.setDescript(rs.getString("descript"));
            c.setStatus(rs.getInt("status"));
            
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutProductDetailsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
