/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICheckoutProductDetails;
import bkap.mapper.CheckoutProductDetailsMapper;
import bkap.model.CheckoutProductDetails;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CheckoutProductDetailsDAO extends AbstractDAO<CheckoutProductDetails> implements ICheckoutProductDetails {

    @Override
    public void add(CheckoutProductDetails c) {
        String sql = "{call checkoutProductDetails_add(?,?,?,?,?)}";
        insert(sql, c.getModel(), c.getProId(), c.getRoomId(), c.getDescript(), c.getStatus());
    }

    @Override
    public List<CheckoutProductDetails> findByRoomId(int roomId) {
        String sql = "{call checkoutProductDetails_findByRoomId(?)}";
        return query(sql, new CheckoutProductDetailsMapper(), roomId);
    }

    @Override
    public void delete(int roomId) {
        String sql = "{call checkoutProductDetails_delete(?)}";
        update(sql, roomId);
    }

    @Override
    public List<CheckoutProductDetails> findByModel(String model, int roomId) {
        String sql = "{call checkoutProductDetails_findByModel(?,?)}";
        return query(sql, new CheckoutProductDetailsMapper(), model, roomId);
    }

}
