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
public class Checkin {
    private int id;
    private String cusPhone;
    private int totalPeople;
    private int cuponId;
    private float totalMoney;
    private float pricePaymentAdvance;
    private float totalServicePrice;
    private String descript;

    public Checkin() {
    }

    public Checkin(int id, String cusPhone, int totalPeople, int cuponId, float totalMoney, float pricePaymentAdvance, float totalServicePrice, String descript) {
        this.id = id;
        this.cusPhone = cusPhone;
        this.totalPeople = totalPeople;
        this.cuponId = cuponId;
        this.totalMoney = totalMoney;
        this.pricePaymentAdvance = pricePaymentAdvance;
        this.totalServicePrice = totalServicePrice;
        this.descript = descript;
    }

    public float getPricePaymentAdvance() {
        return pricePaymentAdvance;
    }

    public void setPricePaymentAdvance(float pricePaymentAdvance) {
        this.pricePaymentAdvance = pricePaymentAdvance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public int getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(int totalPeople) {
        this.totalPeople = totalPeople;
    }

    public int getCuponId() {
        return cuponId;
    }

    public void setCuponId(int cuponId) {
        this.cuponId = cuponId;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public float getTotalServicePrice() {
        return totalServicePrice;
    }

    public void setTotalServicePrice(float totalServicePrice) {
        this.totalServicePrice = totalServicePrice;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
    
    
}
