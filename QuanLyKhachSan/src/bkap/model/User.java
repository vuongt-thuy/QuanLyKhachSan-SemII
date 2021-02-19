/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.model;

import bkap.utils.Utils;
import java.lang.reflect.Field;
import java.util.Date;

/**
 *
 * @author THUY
 */
public class User {

    private int id;
    private String fullname;
    private String username;
    private String password;
    private int levelId;
    private String phone;
    private String address;
    private String image;
    private boolean gender;
    private Date birthday;
    private String descript;
    private Date startDate;
    private Date endDate;
    private int status;
    private boolean isLogin;

    public User() {
    }

    public User(int id, String fullname, String username, String password, int levelId, String phone, String address, String image, boolean gender, Date birthday, String descript, Date startDate, Date endDate, int status, boolean isLogin) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.levelId = levelId;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.gender = gender;
        this.birthday = birthday;
        this.descript = descript;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.isLogin = isLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
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

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    
}
