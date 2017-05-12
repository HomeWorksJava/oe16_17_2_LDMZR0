/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.converter;

import com.mitro.facade.ejbs.GuitarFacade;
import com.mitro.facade.stub.GuitarOwnerStub;
import com.mitro.facade.stub.GuitarStub;
import com.mitro.persistence.entities.GuitarOwner;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hallgato
 */
@Stateless
public class GuitarOwnerConverterImpl implements GuitarOwnerConverter {

    @EJB
    GuitarFacade facade;
    
    private static final Logger LOGGER = Logger.getLogger(GuitarOwnerConverterImpl.class.getName());

    @Override
    public GuitarOwnerStub to(GuitarOwner guitarOwner) {
        GuitarOwnerStub guitarOwnerStub = null;
        List<GuitarStub> guitars = null;
        try {
            guitars = this.facade.getGuitarsOfOwner(guitarOwner.getOwnerUsername());
            guitarOwnerStub = new GuitarOwnerStub(guitarOwner.getOwnerUsername(), guitarOwner.getOwnerEmail(), guitars);
        } catch (Exception e) {
            LOGGER.info("Error occured at converting a GuitarOwner to GuitarOwnerStub ...\n" + e.getLocalizedMessage());
        }
        return guitarOwnerStub;
    }

    @Override
    public List<GuitarOwnerStub> to(List<GuitarOwner> guitarOwners) {
        List<GuitarOwnerStub> stubs = null;
        try {
            for(GuitarOwner g : guitarOwners){
                stubs.add(this.to(g));
            }
        } catch (Exception e) {
            LOGGER.info("Error occured at converting a List<GuitarOwner> to List<GuitarOwnerStub> ...\n" + e.getLocalizedMessage());
        }
        return stubs;
    }

}