/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.CategoryRoom;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface ICategoryRoom extends GenericDAO<CategoryRoom>{
    void add(CategoryRoom c);
    void delete(int id);
    void edit(CategoryRoom c);
    List<CategoryRoom> findAll();
    CategoryRoom findByCateId(int id);    
    
}
