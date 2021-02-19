/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.IUser;
import bkap.mapper.UserMapper;
import bkap.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 */
public class UserDAO extends AbstractDAO<User> implements IUser {

    @Override
    public void add(User u) {
        String sql = "{call user_insert(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        insert(sql, u.getUsername(), u.getPassword(), u.getFullname(), u.getLevelId(), u.getPhone(), u.getAddress(),
                u.getImage(), u.isGender(), u.getBirthday(), u.getDescript(), u.getStartDate(), u.getEndDate(), u.getStatus());
    }

    @Override
    public void delete(int id) {
        String sql = "{call user_delete(?)}";
        update(sql, id);
    }

    @Override
    public void edit(User u) {
        String sql = "{call user_update(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        update(sql, u.getId(), u.getUsername(), u.getPassword(), u.getFullname(),
                u.getLevelId(), u.getPhone(), u.getAddress(), u.getImage(), u.isGender(), u.getBirthday(),
                u.getDescript(), u.getStartDate(), u.getEndDate(), u.getStatus());
    }

    @Override
    public List<User> findAll() {
        String sql = "{call user_findAll()}";
        return query(sql, new UserMapper());
    }

    @Override
    public List<User> findByUsername(String username) {
        String sql = "{call user_findByUsername(?)}";
        return query(sql, new UserMapper(), username);
    }

    @Override
    public List<User> findByFullname(String fullname) {
        String sql = "{call user_findByFullname(?)}";
        return query(sql, new UserMapper(), fullname);
    }

    @Override
    public List<User> findByPhone(String phone) {
        String sql = "{call user_findByPhone(?)}";
        return query(sql, new UserMapper(), phone);
    }

    @Override
    public User login(String username, String password) {
        String sql = "{call login(?,?)}";
        List<User> list = query(sql, new UserMapper(), username, password);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void updateAccount(User u) {
        String sql = "{call user_updateAccount(?,?,?,?,?,?,?,?,?)}";
        update(sql, u.getId(), u.getFullname(), u.getPhone(), u.getUsername(), u.getImage(), u.getPassword(), u.getAddress(), u.isGender(), u.getBirthday());

    }

    public Boolean isLogin(boolean status, String username) {
        String sql = "{call isLogin(?,?)}";

        return true;
    }

}
