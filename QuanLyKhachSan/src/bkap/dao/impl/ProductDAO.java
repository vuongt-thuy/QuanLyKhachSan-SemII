/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.IProduct;
import bkap.mapper.ProductMapper;
import bkap.model.Product;
import java.util.List;

/**
 *
 * @author THUY
 */
public class ProductDAO extends AbstractDAO<Product> implements IProduct{

    @Override
    public void add(Product p) {
        String sql = "{call product_insert(?)}";
        insert(sql, p.getName());
    }

    @Override
    public void edit(Product p) {
        String sql = "{call product_update(?,?)}";
        update(sql, p.getId(), p.getName());
    }

    @Override
    public void delete(int proId) {
        String sql = "{call product_delete(?)}";
        update(sql, proId);
    }

    @Override
    public List<Product> findAll() {
        String sql = "{call product_findAll()}";
        return query(sql, new ProductMapper());
    }

    @Override
    public List<Product> findByName(String name) {
        String sql = "{call product_findByName(?)}";
        return query(sql, new ProductMapper(), name);
    }
    
}
