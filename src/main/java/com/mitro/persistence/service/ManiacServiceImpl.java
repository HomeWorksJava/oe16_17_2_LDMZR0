/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.persistence.service;

import com.mitro.facade.stub.GuitarOwnerStub;
import java.util.List;
import javax.ejb.EJB;
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
    
    @Override
    public List<GuitarOwnerStub> readAllManiacs() throws PersistenceException {
        return null;
    }
    
}
