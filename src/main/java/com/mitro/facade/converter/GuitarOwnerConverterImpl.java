/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.converter;

import com.mitro.facade.stub.GuitarOwnerStub;
import com.mitro.persistence.entities.GuitarOwner;
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
    GuitarConverter converter;
    
    private static final Logger LOGGER = Logger.getLogger(GuitarOwnerConverterImpl.class.getName());
    
    @Override
    public GuitarOwnerStub to(GuitarOwner guitarOwner) {
        GuitarOwnerStub guitarOwnerStub = null;
        try {
            guitarOwnerStub = new GuitarOwnerStub(guitarOwner.getOwnerUsername(), guitarOwner.getOwnerEmail(), 
                    guitarOwner.getOwnerPassword());
            System.out.println(guitarOwnerStub);
        } catch (Exception e) {
            LOGGER.info("Error caused at converting from GuitarOwner to GuitarOwnerStub." + e.getLocalizedMessage());
        }
        return guitarOwnerStub;
    }

}