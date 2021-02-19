/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.Cupon;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface ICupon extends GenericDAO<Cupon>{
    void add(Cupon c);
    void delete(int id);
    void edit(Cupon c);
    void updateStatus();
    List<Cupon> findAll();
    List<Cupon> findByName(String name);
    List<Cupon> findByStatus(int status);
    List<Cupon> findByNameAndStatus(String name, int status);
}
