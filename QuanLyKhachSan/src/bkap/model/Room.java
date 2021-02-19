/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.model;

/**
 *
 * @author THUY
 */
public class Room {    
    private int roomId;
    private int typeId;
    private String image;
    private String descript;
    private int status;

    public Room() {
    }

    public Room(int roomId, int typeId, String image, String descript, int status) {
        this.roomId = roomId;
        this.typeId = typeId;
        this.image = image;
        this.descript = descript;
        this.status = status;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Phòng " + this.roomId;
    }
    
    
}
