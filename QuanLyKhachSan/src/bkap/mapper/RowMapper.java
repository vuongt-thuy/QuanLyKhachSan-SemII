/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.mapper;

import java.sql.ResultSet;

/**
 *
 * @author THUY
 * @param <T>
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs);
}
