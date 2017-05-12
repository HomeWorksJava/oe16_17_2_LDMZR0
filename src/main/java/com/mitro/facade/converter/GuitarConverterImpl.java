/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.converter;

import com.mitro.facade.stub.GuitarBrandStub;
import com.mitro.facade.stub.GuitarOwnerStub;
import com.mitro.facade.stub.GuitarStub;
import com.mitro.persistence.entities.Guitar;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hallgato
 */
@Stateless
public class GuitarConverterImpl implements GuitarConverter {

    @EJB
    GuitarOwnerConverter converter;
    
    private static final Logger LOGGER = Logger.getLogger(GuitarConverterImpl.class.getName());

    @Override
    public GuitarStub to(Guitar guitar) {
        GuitarStub guitarStub = null;
        try{
            GuitarBrandStub guitarBrandStub = GuitarBrandStub.valueOf(guitar.getGuitarbrand().toString());
            GuitarOwnerStub guitarOwnerStub = this.converter.to(guitar.getGuitarOwner());
            guitarStub = new GuitarStub(guitarBrandStub, guitar.getGuitartype(), guitar.getGuitarSerialNumber(),
                            guitar.getGuitarColor(), guitar.getGuitarVintage(), guitar.getGuitarPrice(), guitarOwnerStub);
        } catch(Exception e){
            LOGGER.info("Error occured at converting a Guitar to GuitarStub ...\n" + e.getLocalizedMessage());
        }
        return guitarStub;
    }

    @Override
    public List<GuitarStub> to(List<Guitar> guitars) {
        List<GuitarStub> stubs = null;
        try {
            for(Guitar g : guitars){
                stubs.add(this.to(g));
            }
        } catch (Exception e) {
            LOGGER.info("Error occured at converting a List<Guitar> to List<GuitarStub> ...\n" + e.getLocalizedMessage());
        }
        return stubs;
    }

}





//@Stateless
//public class GuitarConverterImpl implements GuitarConverter{
//
//    @EJB
//    GuitarOwnerConverter converter;
//    
//    private static final Logger LOG = Logger.getLogger(GuitarConverterImpl.class.getName());
//
//    @Override
//    public GuitarStub to(Guitar guitar) {
//        LOG.info("Convert a Guitar to a GuitarStub ...\n");
//        GuitarStub stub = null;
//        try {
//            GuitarBrandStub guitarBrandStub = GuitarBrandStub.valueOf(guitar.getGuitarbrand().toString());
//            GuitarOwnerStub guitarOwnerStub = this.converter.to(guitar.getGuitarOwner());
//            stub = new GuitarStub(guitarBrandStub, guitar.getGuitartype(), guitar.getGuitarSerialNumber(),
//                            guitar.getGuitarColor(), guitar.getGuitarVintage(), guitar.getGuitarPrice(), guitarOwnerStub);
//        } catch (Exception e) {
//            LOG.info("Error occured at conversion from Guitar to GuitarStub ...\n" + e.getLocalizedMessage());
//        }
//        return stub;
//    }
//
//    @Override
//    public List<GuitarStub> to(List<Guitar> guitars) {
//        LOG.info("Convert a List<Guitar> to a List<GuitarStub> ...\n");
//        List<GuitarStub> stubs = null;
//        try {
//            for(Guitar g : guitars){
//            stubs.add(this.to(g));
//            }
//        } catch (Exception e) {
//            LOG.info("Error occured at conversion from Guitar to GuitarStub ...\n" + e.getLocalizedMessage());
//        }
//        return stubs;
//    }
//    
//}
