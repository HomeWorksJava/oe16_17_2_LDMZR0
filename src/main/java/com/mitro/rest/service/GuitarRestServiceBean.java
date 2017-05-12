/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.rest.service;

import com.mitro.facade.ejbs.GuitarFacade;
import com.mitro.facade.exception.FacadeException;
import com.mitro.facade.stub.GuitarInputStub;
import com.mitro.facade.stub.GuitarStub;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author hallgato
 */
@Stateless
public class GuitarRestServiceBean implements GuitarRestService {

    private static final Logger LOGGER = Logger.getLogger(GuitarRestServiceBean.class.getName());

    @EJB
    private GuitarFacade facade;

    @Override
    public GuitarStub getGuitar(Long id) {
            LOGGER.info("Get guitar by id (" + id + ")");
            GuitarStub stub = null;
            try {
                    stub = this.facade.getGuitar(id);
            } catch (Exception e) {
                    e.printStackTrace();
            }
            return stub;
    }

    @Override
    public GuitarStub getGuitar(String serialNumber) {
            LOGGER.info("Get guitar by serial number (" + serialNumber + ")");
            GuitarStub stub = null;
            try {
                    stub = this.facade.getGuitar(serialNumber);
            } catch (Exception e) {
                    e.printStackTrace();
            }
            return stub;
    }

    @Override
    public List<GuitarStub> getAllGuitars() {
            LOGGER.info("Get all guitars");
            List<GuitarStub> stubs = null;
            try {
                    stubs = this.facade.getGuitars();
            } catch (FacadeException e) {
                    e.printStackTrace();
            }
            return stubs;
    }

    @Override
    public void addGuitarStub(GuitarInputStub guitar) {
            LOGGER.info("Add a new guitar.");
            try {
                    this.facade.addGuitar(guitar);
            } catch (FacadeException e) {
                    e.printStackTrace();
            }
    }

}
