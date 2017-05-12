/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.stub;

/**
 *
 * @author hallgato
 */
public class GuitarStub {    

    private GuitarBrandStub guitarbrand;
    private String guitarSerialNumber;
    private String guitartype;
    private String guitarColor;
    private int guitarVintage;
    private double guitarPrice;
    private GuitarOwnerStub guitarOwner;

    public GuitarStub() {
    }

    public GuitarStub(GuitarBrandStub guitarbrand, String guitartype, String guitarSerialNumber, String guitarColor, int guitarVintage, 
            double guitarPrice, GuitarOwnerStub guitarOwner) {
        this.guitarbrand = guitarbrand;
        this.guitarSerialNumber = guitarSerialNumber;
        this.guitartype = guitartype;
        this.guitarColor = guitarColor;
        this.guitarVintage = guitarVintage;
        this.guitarPrice = guitarPrice;
        this.guitarOwner = guitarOwner;
    }

    public GuitarBrandStub getGuitarbrand() {
        return guitarbrand;
    }

    public void setGuitarbrand(GuitarBrandStub guitarbrand) {
        this.guitarbrand = guitarbrand;
    }

    public String getGuitarSerialNumber() {
        return guitarSerialNumber;
    }

    public void setGuitarSerialNumber(String guitarSerialNumber) {
        this.guitarSerialNumber = guitarSerialNumber;
    }

    public String getGuitartype() {
        return guitartype;
    }

    public void setGuitartype(String guitartype) {
        this.guitartype = guitartype;
    }

    public String getGuitarColor() {
        return guitarColor;
    }

    public void setGuitarColor(String guitarColor) {
        this.guitarColor = guitarColor;
    }

    public int getGuitarVintage() {
        return guitarVintage;
    }

    public void setGuitarVintage(int guitarVintage) {
        this.guitarVintage = guitarVintage;
    }

    public double getGuitarPrice() {
        return guitarPrice;
    }

    public void setGuitarPrice(double guitarPrice) {
        this.guitarPrice = guitarPrice;
    }

    public GuitarOwnerStub getGuitarOwner() {
        return guitarOwner;
    }

    public void setGuitarOwner(GuitarOwnerStub guitarOwner) {
        this.guitarOwner = guitarOwner;
    }

    @Override
    public String toString() {
        return "GuitarStub{" + "guitarbrand=" + guitarbrand + ", guitarSerialNumber=" + guitarSerialNumber + ", guitartype=" + guitartype + ", guitarColor=" + guitarColor + ", guitarVintage=" + guitarVintage + ", guitarPrice=" + guitarPrice + ", guitarOwner=" + guitarOwner + '}';
    }
    
    
   
}
