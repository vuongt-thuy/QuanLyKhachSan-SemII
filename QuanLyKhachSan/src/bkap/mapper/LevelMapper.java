/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class LevelMapper implements RowMapper<Level> {

    @Override
    public Level mapRow(ResultSet rs) {
        try {
            Level l = new Level();
            l.setId(rs.getInt("id"));
            l.setName(rs.getString("name"));

            return l;
        } catch (SQLException ex) {
            Logger.getLogger(LevelMapper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }

}
