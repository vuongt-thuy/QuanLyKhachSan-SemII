/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.Product;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface IProduct extends GenericDAO<Product>{
    void add(Product p);
    void edit(Product p);
    void delete(int proId);
    List<Product> findAll();
    List<Product> findByName(String name);
}
