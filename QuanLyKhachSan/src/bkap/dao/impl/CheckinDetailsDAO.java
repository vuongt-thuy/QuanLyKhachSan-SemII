/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao.impl;

import bkap.dao.ICheckinDetails;
import bkap.mapper.CheckinDetailsMapper;
import bkap.model.CheckinDetails;
import java.util.Date;
import java.util.List;

/**
 *
 * @author THUY
 */
public class CheckinDetailsDAO extends AbstractDAO<CheckinDetails> implements ICheckinDetails {

    @Override
    public Integer add(CheckinDetails c) {
        String sql = "INSERT INTO tblCheckinDetails(checkinId, roomId, totalServicePrice, price, startDate, endDate, status) VALUES(?,?,?,?,?,?,?)";
        return insertReturnId(sql, c.getCheckinId(), c.getRoomId(), c.getTotalServicePrice(), c.getPrice(), c.getStartDate(), c.getEndDate(), c.getStatus());
        
    }

    @Override
    public void delete(int detailId) {
        String sql = "{call checkinDetails_delete(?)}";
        update(sql, detailId);
    }

    @Override
    public List<CheckinDetails> findByDetailId(int detailId) {
        String sql = "{call checkinDetails_findByDetailId(?)}";
        return query(sql, new CheckinDetailsMapper(), detailId);
    }
    

    @Override
    public CheckinDetails findByIdRoomStatus(int idR, int status) {
        String sql = "{call findIdCheckinDetailByIdRoom(?,?)}";
        List<CheckinDetails> list = query(sql, new CheckinDetailsMapper(), idR, status);
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public void changeStatusRoom(int id, int status) {
        String sql = "{call checkinDetails_ChangeStatus(?,?)}";
        update(sql, id, status);
    }

    @Override
    public List<CheckinDetails> findAllByStatus(int status) {
        String sql = "{call checkinDetails_findAllByStatus(?)}";
        return query(sql, new CheckinDetailsMapper(), status); 
    }

    @Override
    public List<CheckinDetails> findAll() {
        String sql = "{call checkinDetails_findAll()}";
        return query(sql, new CheckinDetailsMapper());
    }
    
    public Boolean checkStatusRoom(Date start1, Date end1, Date start2, Date end2){
        
        return true;
    }
}
