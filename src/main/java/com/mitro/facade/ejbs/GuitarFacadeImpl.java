/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.ejbs;

import com.mitro.facade.converter.GuitarConverter;
import com.mitro.facade.converter.GuitarOwnerConverter;
import com.mitro.facade.exception.FacadeException;
import com.mitro.facade.stub.GuitarInputStub;
import com.mitro.facade.stub.GuitarStub;
import com.mitro.persistence.entities.Guitar;
import com.mitro.persistence.service.GuitarService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

/**
 *
 * @author hallgato
 */
@Stateless
public class GuitarFacadeImpl implements GuitarFacade {

    private static final Logger LOGGER = Logger.getLogger(GuitarFacadeImpl.class.getName());

    @EJB
    private GuitarService guitarService;
    @EJB
    private GuitarConverter guitarConverter;

    @Override
    public GuitarStub getGuitar(Long guitarId) throws FacadeException {
            LOGGER.info("Get Guitar (id: " + guitarId + ")");
            GuitarStub guitar = null;
            try {
                    guitar = this.guitarConverter.to(this.guitarService.read(guitarId));
            } catch (PersistenceException e) {
                    LOGGER.info("Error occured at fetching of guitar." + e.getLocalizedMessage());
                    throw new FacadeException(e.getLocalizedMessage());
            }
            return guitar;
    }

    @Override
    public List<GuitarStub> getGuitars() throws FacadeException {
            LOGGER.info("Get all of guitars (facade).");
            List<GuitarStub> guitarStubs = new ArrayList<GuitarStub>();
            try {
                    List<Guitar> guitars = this.guitarService.readAll();
                    for (Guitar g : guitars) {
                            guitarStubs.add(this.guitarConverter.to(g));
                    }
            } catch (PersistenceException e) {
                    LOGGER.info("Error occured at fetching all of guitars." + e.getLocalizedMessage());
                    throw new FacadeException(e.getLocalizedMessage());
            }
            return guitarStubs;
    }

    @Override
    public GuitarStub getGuitar(String serial) throws FacadeException {
            LOGGER.info("Get a guitar by serial number (facade).");
            GuitarStub guitar = null;
            try {
                    guitar = this.guitarConverter.to(this.guitarService.readBySerialNumber(serial));
            } catch (PersistenceException e) {
                    LOGGER.info("Error occured at fetching of guitar." + e.getLocalizedMessage());
                    throw new FacadeException(e.getLocalizedMessage());
            }
            return guitar;
    }

    @Override
    public void addGuitar(GuitarInputStub guitar) throws FacadeException {
            LOGGER.info("Add a guitar to the application (facade).");
            try {
                    this.guitarService.insertGuitar(guitar.getGuitarBrand(), guitar.getGuitarType(), guitar.getColor(),
                                    guitar.getSerialNumber(), guitar.getVintage(), guitar.getPrice(), guitar.getOwner());
            } catch (PersistenceException e) {
                    LOGGER.info("Unknown error caused at add process.");
                    throw new FacadeException("Unknown error caused at add process. " + e.getLocalizedMessage());
            }
    }

}