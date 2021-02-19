/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.Checkin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class CheckinMapper implements RowMapper<Checkin> {

    @Override
    public Checkin mapRow(ResultSet rs) {
        try {
            Checkin c = new Checkin();
            c.setId(rs.getInt("id"));
            c.setCusPhone(rs.getString("cusPhone"));
            c.setPricePaymentAdvance(rs.getFloat("pricePaymentAdvance"));
            c.setTotalPeople(rs.getInt("totalPeople"));
            c.setTotalMoney(rs.getFloat("totalMoney"));
            c.setTotalServicePrice(rs.getFloat("totalServicePrice"));
            c.setDescript(rs.getString("descript"));

            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CheckinMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
