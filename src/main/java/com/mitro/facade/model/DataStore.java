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
public class DataStore {
    
    private static final DataStore INSTANCE = new DataStore();
    private DrinkList drinks = new DrinkList();
    
    public DataStore(){
        Drink szolo = new Drink(1L, "Szőlő pálinka", 80.0, null, "kimért");
        szolo.setPrice(new Price("deci", 5.0, 300.0));
        drinks.addSpirit(szolo);
        
        Drink soproni = new Drink(2L, "Soproni sör", 15.0, null, "üveges");
        soproni.setPrice(new Price("deci", 5.0, 250.0));
        drinks.addBeer(soproni);
        
        Drink bor = new Drink(3L, "Homokgyöngye", 30.0, null, "üveges");
        bor.setPrice(new Price("deci", 5.0, 180.0));
        drinks.addWine(bor);
    }
    
    public static DataStore getInstance(){
        return INSTANCE;
    }
    
    public DrinkList getDrinks(){
        return drinks;
    }
}
