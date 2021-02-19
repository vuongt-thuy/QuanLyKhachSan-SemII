/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.IRoom;
import bkap.mapper.RoomMapper;
import bkap.model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class RoomDAO extends AbstractDAO<Room> implements IRoom {

    @Override
    public Integer add(Room r) {
        Integer roomId = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "INSERT INTO tblRoom(typeId, image, descript, status) VALUES(?,?,?,?)";
        try {
            conn = getConnect();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, r.getTypeId());
            ps.setString(2, r.getImage());
            ps.setString(3, r.getDescript());
            ps.setInt(4, r.getStatus());

            ps.executeUpdate();            
            rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                roomId = rs.getInt(1);
            }
            conn.commit();
            return roomId;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    @Override
    public void edit(Room r) {
        String sql = "{call room_update(?,?,?,?,?)}";
        update(sql, r.getRoomId(), r.getTypeId(), r.getImage(), r.getDescript(), r.getStatus());
    }

    @Override
    public void delete(int roomId) {
        String sql = "{call room_delete(?)}";
        update(sql, roomId);
    }

    @Override
    public List<Room> findAll() {
        String sql = "{call room_findAll()}";
        return query(sql, new RoomMapper());
    }

    @Override
    public List<Room> findByStatus(int status) {
        String sql = "{call room_findByStatus(?)}";
        return query(sql, new RoomMapper(), status);
    }  

    @Override
    public Room findByRoomId(int roomId) {
        String sql = "{call room_findByRoomId(?)}";
        List<Room> list = query(sql, new RoomMapper(), roomId);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void changeStatus(int id, int status) {
        String sql = "{call room_ChangeStatus(?,?)}";
        update(sql, id, status);
    }
}
