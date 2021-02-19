/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.CheckinDetails;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface ICheckinDetails extends GenericDAO<CheckinDetails>{
    Integer add(CheckinDetails c);
    void delete(int detailId);
    List<CheckinDetails> findAll();
    List<CheckinDetails> findAllByStatus(int status);
    List<CheckinDetails> findByDetailId(int detailId);
    CheckinDetails findByIdRoomStatus(int idR, int status);
    void changeStatusRoom(int id, int status);
}
