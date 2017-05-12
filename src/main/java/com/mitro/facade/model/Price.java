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
public class Price {
    
    private String unit;
    private double kiszereles;
    private double price;

    public Price() {
    }

    public Price(String unit, double kiszereles, double price) {
        this.unit = unit;
        this.kiszereles = kiszereles;
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getKiszereles() {
        return kiszereles;
    }

    public void setKiszereles(double kiszereles) {
        this.kiszereles = kiszereles;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" + "unit=" + unit + ", kiszereles=" + kiszereles + ", price=" + price + '}';
    }
    
}
