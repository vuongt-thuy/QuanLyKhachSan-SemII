/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.Level;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface ILevel extends GenericDAO<Level>{
    List<Level> findAll();
    List<Level> findByName(String name);
    void add(Level l);
    void edit(Level l);
    void delete(int id);
}
