/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.mapper.RowMapper;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> rowmapper, Object...parameters);
    void update(String sql, Object...parameters);
    void insert(String sql, Object...parameters);
    Integer insertReturnId(String sql, Object...parameters);
}
