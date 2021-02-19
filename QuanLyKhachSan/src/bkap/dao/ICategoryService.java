/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.CategoryService;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface ICategoryService extends GenericDAO<CategoryService>{
    void add(CategoryService c);
    void delete(int id);
    void edit(CategoryService c);
    List<CategoryService> findAll();
    List<CategoryService> findByName(String name);
}
