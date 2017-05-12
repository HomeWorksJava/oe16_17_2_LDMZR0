/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.ejbs;

import com.mitro.facade.exception.FacadeException;
import com.mitro.facade.stub.GuitarInputStub;
import com.mitro.facade.stub.GuitarStub;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hallgato
 */
@Local
public interface GuitarFacade {

	GuitarStub getGuitar(Long guitarId) throws FacadeException;

	GuitarStub getGuitar(String serial) throws FacadeException;
        
        List<GuitarStub> getGuitarsOfOwner(String ownername) throws FacadeException;

	List<GuitarStub> getGuitars() throws FacadeException;

	void addGuitar(GuitarInputStub guitar) throws FacadeException;

}