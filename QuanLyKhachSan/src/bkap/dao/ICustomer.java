/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.Customer;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface ICustomer extends GenericDAO<Customer>{
    String add(Customer cus);
    void edit(Customer cus);
    void delete(String phone);
    List<Customer> findAll();
    List<Customer> findByPhone(String phone);
    List<Customer> findByNumIdentityCard(String numIdentityCard);
}
