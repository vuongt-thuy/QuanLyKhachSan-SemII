/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICategoryService;
import bkap.mapper.CategoryServiceMapper;
import bkap.model.CategoryService;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CategoryServiceDAO extends AbstractDAO<CategoryService> implements ICategoryService {

    @Override
    public void add(CategoryService c) {
        String sql = "{call categoryService_insert(?)}";
        insert(sql, c.getName());
    }

    @Override
    public void delete(int id) {
        String sql = "{call categoryService_delete(?)}";
        update(sql, id);
    }

    @Override
    public void edit(CategoryService c) {
        String sql = "{call categoryService_update(?,?)}";
        update(sql, c.getId(), c.getName());
    }

    @Override
    public List<CategoryService> findAll() {
        String sql = "{call categoryService_findAll()}";
        return query(sql, new CategoryServiceMapper());
    }

    @Override
    public List<CategoryService> findByName(String name) {
        String sql = "{call categoryService_findByName(?)}";
        return query(sql, new CategoryServiceMapper(), name);
    }
}
