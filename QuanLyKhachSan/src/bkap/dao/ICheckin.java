/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.Checkin;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface ICheckin extends GenericDAO<Checkin>{
    Integer add(Checkin c);
    void delete(int id);
    List<Checkin> findAll();
    Checkin findById(int id);
}
