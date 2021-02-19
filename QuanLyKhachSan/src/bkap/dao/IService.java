/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.Service;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface IService extends GenericDAO<Service>{
    void add(Service s);
    void edit(Service s);
    void delete(int id);
    List<Service> findAll();
    List<Service> findByName(String name);
    Service findByID(int id);
}
