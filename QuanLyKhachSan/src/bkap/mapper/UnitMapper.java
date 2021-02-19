/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.Unit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class UnitMapper implements RowMapper<Unit> {

    @Override
    public Unit mapRow(ResultSet rs) {
        try {
            Unit u = new Unit();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));

            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UnitMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
