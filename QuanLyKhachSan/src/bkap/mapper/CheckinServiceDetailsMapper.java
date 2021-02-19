/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.CheckinServiceDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class CheckinServiceDetailsMapper implements RowMapper<CheckinServiceDetails> {

    @Override
    public CheckinServiceDetails mapRow(ResultSet rs) {
        try {
            CheckinServiceDetails c = new CheckinServiceDetails();
            c.setIdService(rs.getInt("idServicee"));
            c.setIdCheckinDetails(rs.getInt("idCheckinDetails"));
            c.setQuantity(rs.getInt("quantity"));
            c.setPrice(rs.getFloat("price"));

            return c;

        } catch (SQLException ex) {
            Logger.getLogger(CheckinServiceDetailsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
