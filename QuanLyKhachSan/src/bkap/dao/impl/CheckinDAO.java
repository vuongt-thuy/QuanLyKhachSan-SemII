/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICheckin;
import bkap.mapper.CheckinMapper;
import bkap.model.Checkin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CheckinDAO extends AbstractDAO<Checkin> implements ICheckin {

    @Override
    public void delete(int id) {
        String sql = "{call checkin_delete(?)}";
        update(sql, id);
    }

    @Override
    public List<Checkin> findAll() {
        String sql = "{call checkin_findAll()}";
        return query(sql, new CheckinMapper());
    }

    @Override
    public Integer add(Checkin c) {
        String sql = "INSERT INTO tblCheckin(cusPhone, totalPeople, cuponId, pricePaymentAdvance, totalMoney, totalServicePrice, descript) VALUES(?,?,?,?,?,?,?)";
        return insertReturnId(sql, c.getCusPhone(), c.getTotalPeople(), c.getCuponId(), c.getPricePaymentAdvance(), c.getTotalMoney(), c.getTotalServicePrice(), c.getDescript());

    }

    @Override
    public Checkin findById(int id) {
        String sql = "{call checkin_findById(?)}";
        List<Checkin> list = query(sql, new CheckinMapper(), id);
        return list.size() == 0 ? null : list.get(0);
    
    }
}
