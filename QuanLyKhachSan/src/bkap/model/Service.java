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
public class Service {
    private int id;
    private String name;
    private float inputPrice;
    private float outputPrice;
    private int unit;
    private int catService;

    public Service() {
    }

    public Service(int id, String name, float inputPrice, float outputPrice, int unit, int catService) {
        this.id = id;
        this.name = name;
        this.inputPrice = inputPrice;
        this.outputPrice = outputPrice;
        this.unit = unit;
        this.catService = catService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getCatService() {
        return catService;
    }

    public void setCatService(int catService) {
        this.catService = catService;
    }

    public float getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(float inputPrice) {
        this.inputPrice = inputPrice;
    }

    public float getOutputPrice() {
        return outputPrice;
    }

    public void setOutputPrice(float outputPrice) {
        this.outputPrice = outputPrice;
    }
    
    
}
