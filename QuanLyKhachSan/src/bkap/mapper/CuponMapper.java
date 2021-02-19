/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.Cupon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class CuponMapper implements RowMapper<Cupon> {

    @Override
    public Cupon mapRow(ResultSet rs) {
        try {
            Cupon c = new Cupon();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setDiscount(rs.getFloat("discount"));
            c.setMaxQuantity(rs.getInt("maxQuantity"));
            c.setStatus(rs.getInt("status"));
            c.setDescript(rs.getString("descript"));
            c.setStartDate(rs.getDate("startDate"));
            c.setEndDate(rs.getDate("endDate"));
            c.setCreatedAt(rs.getDate("createdAt"));
            c.setUpdatedAt(rs.getDate("updatedAt"));

            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CuponMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
