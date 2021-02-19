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
public class CheckoutProductDetails {
    private String model;
    private int proId;
    private int roomId;
    private String descript;
    private int status;

    public CheckoutProductDetails() {
    }

    public CheckoutProductDetails(String model, int proId, int roomId, String descript, int status) {
        this.model = model;
        this.proId = proId;
        this.roomId = roomId;
        this.descript = descript;
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
    
    
}
