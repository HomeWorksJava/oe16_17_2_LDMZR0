///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mitro.facade.ejbs;
//
//import com.mitro.facade.converter.GuitarOwnerConverter;
//import com.mitro.facade.exception.FacadeException;
//import com.mitro.facade.stub.GuitarOwnerStub;
//import com.mitro.persistence.service.ManiacService;
//import java.util.List;
//import java.util.logging.Logger;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//
///**
// *
// * @author hallgato
// */
//@Stateless
//public class OwnerFacadeImpl implements OwnerFacade{
//
//    @EJB
//    ManiacService service;
//    
//    @EJB
//    GuitarOwnerConverter converter;
//    
//    private static final Logger LOGGER = Logger.getLogger(OwnerFacadeImpl.class.getName());
//    
//    @Override
//    public List<GuitarOwnerStub> getManiacs() throws FacadeException {
//        List<GuitarOwnerStub> stubs = null;
//        try {
//            stubs = this.converter.to(this.service.readAllManiacs());
//        } catch (Exception e) {
//            LOGGER.info("Error occured at fetching the OwnerStubs ...\n" + e.getLocalizedMessage());
//        }
//        return stubs;
//    }
//    
//}
