/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.GenericDAO;
import bkap.mapper.RowMapper;
import bkap.utils.SystemConstant;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THUY
 * @param <T>
 */
public class AbstractDAO<T> implements GenericDAO<T> {

    public Connection getConnect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://" + SystemConstant.host + ":" + SystemConstant.port + ";databasename=" + SystemConstant.databasename + ";username=" + SystemConstant.username + ";password=" + SystemConstant.password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowmapper, Object... parameters) {
        List<T> list = new ArrayList<>();

        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conn = getConnect();
            cs = conn.prepareCall(sql);
            setParameters(cs, parameters);
            rs = cs.executeQuery();

            while (rs.next()) {
                list.add(rowmapper.mapRow(rs));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    cs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void insert(String sql, Object... parameters) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = getConnect();
            conn.setAutoCommit(false);
            cs = conn.prepareCall(sql);
            setParameters(cs, parameters);
            cs.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    cs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = getConnect();
            conn.setAutoCommit(false);
            cs = conn.prepareCall(sql);
            setParameters(cs, parameters);
            cs.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    cs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void setParameters(CallableStatement cs, Object... parameters) {
        try {
            int index = 1;
            for (Object param : parameters) {
                cs.setObject(index, param);
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setParameters(PreparedStatement ps, Object... parameters) {
        try {
            int index = 1;
            for (Object param : parameters) {
                ps.setObject(index, param);
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer insertReturnId(String sql, Object... parameters) {
        ResultSet resultSet = null;
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Integer id = null;
            conn = getConnect();
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameters(statement, parameters);
            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            conn.commit();
            return id;
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
