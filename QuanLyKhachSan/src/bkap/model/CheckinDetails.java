/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.model;

import java.util.Date;

/**
 *
 * @author THUY
 */
public class CheckinDetails {
    private int detailId;
    private int checkinId;
    private int roomId;
    private float totalServicePrice;
    private float price;
    private float exPrice;
    private float subPrice;
    private Date startDate;
    private Date endDate;
    private int status;

    public CheckinDetails() {
    }

    public CheckinDetails(int detailId, int checkinId, int roomId, float totalServicePrice, float price, float exPrice, float subPrice, Date startDate, Date endDate, int status) {
        this.detailId = detailId;
        this.checkinId = checkinId;
        this.roomId = roomId;
        this.totalServicePrice = totalServicePrice;
        this.price = price;
        this.exPrice = exPrice;
        this.subPrice = subPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(int checkinId) {
        this.checkinId = checkinId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public float getTotalServicePrice() {
        return totalServicePrice;
    }

    public void setTotalServicePrice(float totalServicePrice) {
        this.totalServicePrice = totalServicePrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getExPrice() {
        return exPrice;
    }

    public void setExPrice(float exPrice) {
        this.exPrice = exPrice;
    }

    public float getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(float subPrice) {
        this.subPrice = subPrice;
    }

    
    
    
}
