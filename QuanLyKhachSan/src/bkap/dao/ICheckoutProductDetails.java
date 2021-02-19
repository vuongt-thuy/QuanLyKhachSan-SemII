/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.CheckoutProductDetails;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface ICheckoutProductDetails extends GenericDAO<CheckoutProductDetails>{
    void add(CheckoutProductDetails c);
    List<CheckoutProductDetails> findByRoomId(int roomId);
    List<CheckoutProductDetails> findByModel(String model, int roomId);
    void delete(int roomId);
}
