/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.User;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface IUser extends GenericDAO<User>{
    void add(User user);
    void delete(int id);
    void edit(User user);
    User login(String username, String password);
    List<User> findAll();
    List<User> findByUsername(String username);
    List<User> findByFullname(String fullname);
    List<User> findByPhone(String phone);
    void updateAccount(User user);
    Boolean isLogin(boolean status, String username);
}
