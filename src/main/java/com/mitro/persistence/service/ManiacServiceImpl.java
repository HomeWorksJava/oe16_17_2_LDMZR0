/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.persistence.service;

import com.mitro.persistence.entities.GuitarOwner;
import com.mitro.persistence.query.OwnerQuery;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author hallgato
 */
@Stateless(mappedName = "ejb/maniacService")
public class ManiacServiceImpl implements ManiacService{  
    
    @PersistenceContext(name = "GuitarManiaPU")
    private EntityManager entityManager;
    
    private static final Logger LOGGER = Logger.getLogger(ManiacServiceImpl.class.getName());
    
    @Override
    public List<GuitarOwner> readAllManiacs() throws PersistenceException {
        LOGGER.info("List all of maniacs.");
        List<GuitarOwner> owners = null;
        try {
            owners = this.entityManager.createNamedQuery(OwnerQuery.GET_ALL, GuitarOwner.class).getResultList();
        } catch (Exception e) {
            LOGGER.info("Error occured at fetching the Owners ...\n" + e.getLocalizedMessage());
            throw new PersistenceException("Error occured at fetching the Owners ...\n" + e.getLocalizedMessage());
        }
        return owners;
    }
    
}
