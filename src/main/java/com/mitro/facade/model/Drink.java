/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.model;

/**
 *
 * @author Mitró Tamás
 */
public class Drink {
    
    private Long drinkId;
    private String drinkName;
    private double alcoholPercent;
    private Price price;
    private String type;

    public Drink() {
    }

    public Drink(Long drinkId, String drinkName, double alkoholTartalom, Price price, String type) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.alcoholPercent = alkoholTartalom;
        this.price = price;
        this.type = type;
    }

    public Long getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(Long drinkId) {
        this.drinkId = drinkId;
    }


    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public double getAlcoholPercent() {
        return alcoholPercent;
    }

    public void setAlcoholPercent(double alcoholPercent) {
        this.alcoholPercent = alcoholPercent;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Drink{" + "drinkName=" + drinkName + ", alcoholPercent=" + alcoholPercent + ", price=" + price + ", type=" + type + '}';
    }
    
}
