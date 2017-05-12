package com.mitro.facade.ejbs;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mitro.ejbs;
//
//import com.mitro.entities.Drinktype;
//import java.util.List;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
///**
// *
// * @author Mitró Tamás
// */
//@Stateless
//public class DrinkService {
//    
//    @PersistenceContext
//    EntityManager entitymanager;
//    
//    public List<Drinktype> getAll(){
//        return this.entitymanager.createNamedQuery("Drinktype.findAll").getResultList();
//    }
//    
//    public void addDrink(Drinktype drink){
//        this.entitymanager.persist(drink);
//    }
//    
//}
