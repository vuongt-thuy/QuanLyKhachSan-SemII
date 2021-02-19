/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import bkap.model.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class ServiceMapper implements RowMapper<Service> {

    @Override
    public Service mapRow(ResultSet rs) {
        try {
            Service s = new Service();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setInputPrice(rs.getFloat("inputPrice"));
            s.setOutputPrice(rs.getFloat("price"));
            s.setUnit(rs.getInt("unit"));
            s.setCatService(rs.getInt("catService"));

            return s;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
