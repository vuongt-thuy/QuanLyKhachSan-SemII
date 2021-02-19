/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.dao;

import bkap.model.Room;
import java.util.List;

/**
 *
 * @author THUY
 */
public interface IRoom extends GenericDAO<Room>{
    Integer add(Room room);
    void edit(Room room);
    void delete(int roomId);
    List<Room> findAll();    
    Room findByRoomId(int roomId);    
    List<Room> findByStatus(int status);   
    void changeStatus(int id, int status);
}
