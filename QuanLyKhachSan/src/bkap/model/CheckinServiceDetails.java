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
public class CheckinServiceDetails {
    private int idService;
    private int idCheckinDetails;
    private int quantity;
    private float price;

    public CheckinServiceDetails() {
    }

    public CheckinServiceDetails(int idService, int idCheckinDetails, int quantity, float price) {
        this.idService = idService;
        this.idCheckinDetails = idCheckinDetails;
        this.quantity = quantity;
        this.price = price;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getIdCheckinDetails() {
        return idCheckinDetails;
    }

    public void setIdCheckinDetails(int idCheckinDetails) {
        this.idCheckinDetails = idCheckinDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
