/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs) {
        try {
            Customer c = new Customer();
            c.setPhone(rs.getString("phone"));
            c.setFullname(rs.getString("fullname"));
            c.setEmail(rs.getString("email"));
            c.setAddress(rs.getString("address"));
            c.setGender(rs.getBoolean("gender"));
            c.setNumIdentityCard(rs.getString("numIdentityCard"));
            c.setDescript(rs.getString("descript"));
            c.setCreatedAt(rs.getDate("createdAt"));
            c.setUpdatedAt(rs.getDate("updatedAt"));

            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
