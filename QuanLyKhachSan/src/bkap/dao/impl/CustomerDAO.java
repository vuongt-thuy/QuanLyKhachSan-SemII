/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICustomer;
import bkap.mapper.CustomerMapper;
import bkap.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CustomerDAO extends AbstractDAO<Customer> implements ICustomer {

    @Override
    public void edit(Customer c) {
        String sql = "{call customer_update(?,?,?,?,?,?,?,?,?)}";
        update(sql, c.getPhone(), c.getFullname(), c.getEmail(), c.getAddress(), c.isGender(), c.getNumIdentityCard(), c.getDescript(), c.getCreatedAt(), c.getUpdatedAt());
    }

    @Override
    public void delete(String phone) {
        String sql = "{call customer_delete(?)}";
        update(sql, phone);
    }

    @Override
    public List<Customer> findAll() {
        String sql = "{call customer_findAll()}";
        return query(sql, new CustomerMapper());
    }

    @Override
    public List<Customer> findByPhone(String phone) {
        String sql = "{call customer_findByPhone(?)}";
        return query(sql, new CustomerMapper(), phone);
    }

    @Override
    public List<Customer> findByNumIdentityCard(String numIdentityCard) {
        String sql = "{call customer_findByNumIdentityCard(?)}";
        return query(sql, new CustomerMapper(), numIdentityCard);
    }

    @Override
    public String add(Customer c) {
        String sql = "INSERT INTO tblCustomer(phone, fullname, email, address, gender, numIdentityCard, descript, createdAt, updatedAt)\n" +
"	VALUES(?,?,?,?,?,?,?,?,?)";
        ResultSet resultSet = null;
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            String phone = null;
            conn = getConnect();
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(sql);
            statement.setString(1, c.getPhone());
            statement.setString(2, c.getFullname());
            statement.setString(3, c.getEmail());
            statement.setString(4, c.getAddress());
            statement.setBoolean(5, c.isGender());
            statement.setString(6, c.getNumIdentityCard());
            statement.setString(7, c.getDescript());
            java.sql.Date createdDate = new java.sql.Date(c.getCreatedAt().getTime());
            java.sql.Date updatedDate = new java.sql.Date(c.getUpdatedAt().getTime());
            statement.setDate(8, createdDate);
            statement.setDate(9, updatedDate);
            statement.executeUpdate();
            conn.commit();
            return c.getPhone();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    statement.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        return null;
       }
}
