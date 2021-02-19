/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.CheckinDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class CheckinDetailsMapper implements RowMapper<CheckinDetails> {

    @Override
    public CheckinDetails mapRow(ResultSet rs) {
        try {
            CheckinDetails c = new CheckinDetails();
            c.setDetailId(rs.getInt("detailId"));
            c.setCheckinId(rs.getInt("checkinId"));
            c.setRoomId(rs.getInt("roomId"));
            c.setTotalServicePrice(rs.getFloat("totalServicePrice"));
            c.setSubPrice(rs.getFloat("subPrice"));
            c.setExPrice(rs.getFloat("exPrice"));
            c.setPrice(rs.getFloat("price"));
            c.setStartDate(rs.getDate("startDate"));
            c.setEndDate(rs.getDate("endDate"));
            c.setStatus(rs.getInt("status"));

            return c;
        } catch (SQLException ex) {
            Logger.getLogger(CheckinDetailsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
