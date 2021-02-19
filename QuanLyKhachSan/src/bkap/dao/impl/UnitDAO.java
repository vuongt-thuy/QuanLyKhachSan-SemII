/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.IUnit;
import bkap.mapper.UnitMapper;
import bkap.model.Unit;
import java.util.List;

/**
 *
 * @author THUY
 */
public class UnitDAO extends AbstractDAO<Unit> implements IUnit {
    
    @Override
    public void add(Unit u) {
        String sql = "{call unit_insert(?)}";
        insert(sql, u.getName());
    }

    @Override
    public void delete(int id) {
        String sql = "{call unit_delete(?)}";
        update(sql, id);
    }

    @Override
    public void edit(Unit u) {
        String sql = "{call unit_update(?,?)}";
        update(sql, u.getId(), u.getName());
    }
    
    @Override
    public List<Unit> findAll() {
        String sql = "{call unit_findAll()}";
        return query(sql, new UnitMapper());
    }

    @Override
    public List<Unit> findByName(String name) {
        String sql = "{call unit_findByName(?)}";
        return query(sql, new UnitMapper(), name);
    }

}
