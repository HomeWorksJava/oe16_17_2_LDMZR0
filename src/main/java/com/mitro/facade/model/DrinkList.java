/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mitró Tamás
 */
public class DrinkList {
    private List<Drink> beers = new ArrayList<>();
    private List<Drink> spirits = new ArrayList<>();
    private List<Drink> wines = new ArrayList<>();

    public DrinkList() {
    }

    public void addBeer(Drink drink){
        this.beers.add(drink);
    }
    
    public void addSpirit(Drink drink){
        this.spirits.add(drink);
    }
    
    public void addWine(Drink drink){
        this.wines.add(drink);
    }
    
    public List<Drink> getBeers() {
        return beers;
    }

    public void setBeers(List<Drink> beers) {
        this.beers = beers;
    }

    public List<Drink> getSpirits() {
        return spirits;
    }

    public void setSpirits(List<Drink> spirits) {
        this.spirits = spirits;
    }

    public List<Drink> getWines() {
        return wines;
    }

    public void setWines(List<Drink> wines) {
        this.wines = wines;
    }

    @Override
    public String toString() {
        return "DrinkList{" + "beers=" + beers + ", spirits=" + spirits + ", wines=" + wines + '}';
    }
    
}
