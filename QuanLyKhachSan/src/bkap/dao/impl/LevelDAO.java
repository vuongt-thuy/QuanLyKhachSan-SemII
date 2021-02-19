/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ILevel;
import bkap.mapper.LevelMapper;
import bkap.model.Level;
import java.util.List;

/**
 *
 * @author THUY
 */
public class LevelDAO extends AbstractDAO<Level> implements ILevel{

    @Override
    public List<Level> findAll() {
        String sql = "{call level_findAll()}";
        return query(sql, new LevelMapper());
    }

    @Override
    public void add(Level l) {
        String sql = "{call level_insert(?)}";
        insert(sql, l.getName());
    }

    @Override
    public void edit(Level l) {
        String sql = "{call level_update(?,?)}";
        update(sql, l.getId(), l.getName());
    }

    @Override
    public void delete(int id) {
        String sql = "{call level_delete(?)}";
        update(sql, id);
    }

    @Override
    public List<Level> findByName(String name) {
        String sql = "{call level_findByName(?)}";
        return query(sql, new LevelMapper(), name);
    }
    
}
