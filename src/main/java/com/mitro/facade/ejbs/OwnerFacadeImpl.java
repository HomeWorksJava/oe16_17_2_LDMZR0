/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.ejbs;

import com.mitro.facade.converter.GuitarOwnerConverter;
import com.mitro.facade.exception.FacadeException;
import com.mitro.facade.stub.GuitarOwnerStub;
import com.mitro.persistence.entities.GuitarOwner;
import com.mitro.persistence.service.ManiacService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hallgato
 */
@Stateless
public class OwnerFacadeImpl implements OwnerFacade{

    @EJB
    ManiacService service;
    
    @EJB
    GuitarOwnerConverter converter;
    
    private static final Logger LOGGER = Logger.getLogger(OwnerFacadeImpl.class.getName());
    
    @Override
    public Set<GuitarOwnerStub> getManiacs() throws FacadeException {
        Set<GuitarOwnerStub> stubs = new HashSet<GuitarOwnerStub>();
        try {
            List<GuitarOwner> entities = this.service.readAllManiacs();
            for(GuitarOwner go : entities){
                stubs.add(this.converter.to(go));
            }
        } catch (Exception e) {
            LOGGER.info("Error occured at fetching the OwnerStubs ...\n" + e.getLocalizedMessage());
        }
        return stubs;
    }
    
}
