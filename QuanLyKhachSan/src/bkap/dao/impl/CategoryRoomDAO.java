/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICategoryRoom;
import bkap.mapper.CategoryRoomMapper;
import bkap.model.CategoryRoom;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CategoryRoomDAO extends AbstractDAO<CategoryRoom> implements ICategoryRoom{

    @Override
    public List<CategoryRoom> findAll() {
        String sql = "{call categoryRoom_findAll()}";
        return query(sql, new CategoryRoomMapper());
    }

    @Override
    public void add(CategoryRoom c) {
        String sql = "{call categoryRoom_insert(?,?)}";
        insert(sql, c.getName(), c.getPrice());
    }

    @Override
    public void delete(int id) {
        String sql = "{call categoryRoom_delete(?)}";
        update(sql, id);
    }

    @Override
    public void edit(CategoryRoom c) {
        String sql = "{call categoryRoom_update(?,?,?)}";
        update(sql, c.getId(), c.getName(), c.getPrice());
    }
    
    @Override
    public CategoryRoom findByCateId(int id) {
        String sql = "{call category_findByCateRoomId(?)}";
        List<CategoryRoom> list = query(sql, new CategoryRoomMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }
    
}
