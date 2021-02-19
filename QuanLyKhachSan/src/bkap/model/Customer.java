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
public class Customer {
    private String phone;
    private String fullname;
    private String email;
    private String address;
    private boolean gender;
    private String numIdentityCard;
    private String descript;
    private Date createdAt;
    private Date updatedAt;

    public Customer() {
    }

    public Customer(String phone, String fullname, String email, String address, boolean gender, String numIdentityCard, String descript, Date createdAt, Date updatedAt) {
        this.phone = phone;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.numIdentityCard = numIdentityCard;
        this.descript = descript;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNumIdentityCard() {
        return numIdentityCard;
    }

    public void setNumIdentityCard(String numIdentityCard) {
        this.numIdentityCard = numIdentityCard;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    
}
