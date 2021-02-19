/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class RoomMapper implements RowMapper<Room> {

    @Override
    public Room mapRow(ResultSet rs) {
        try {
            Room r = new Room();
            r.setRoomId(rs.getInt("roomId"));
            r.setTypeId(rs.getInt("typeId"));
            r.setImage(rs.getString("image"));
            r.setDescript(rs.getString("descript"));
            r.setStatus(rs.getInt("status"));

            return r;
        } catch (SQLException ex) {
            Logger.getLogger(RoomMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
