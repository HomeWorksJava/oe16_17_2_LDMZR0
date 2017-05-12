/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.converter;

import com.mitro.facade.stub.GuitarOwnerStub;
import com.mitro.persistence.entities.GuitarOwner;
import javax.ejb.Stateless;

/**
 *
 * @author hallgato
 */
@Stateless
public class GuitarOwnerConverterImpl implements GuitarOwnerConverter {

	@Override
	public GuitarOwnerStub to(GuitarOwner guitarOwner) {
		GuitarOwnerStub guitarOwnerStub = new GuitarOwnerStub(guitarOwner.getOwnerUsername(),
				guitarOwner.getOwnerEmail());
		return guitarOwnerStub;
	}

}


//@Stateless
//public class GuitarOwnerConverterImpl implements GuitarOwnerConverter{
//    
//    @EJB
//    GuitarConverter converter;
//    
//    private static final Logger LOG = Logger.getLogger(GuitarOwnerConverterImpl.class.getName());
//    
//    @Override
//    public GuitarOwnerStub to(GuitarOwner guitarOwner) {
//        LOG.info("Convert a GuitarOwner to GuitarOwnerStub ...\n");
//        GuitarOwnerStub stub = null;
//        try {
//            List<Guitar> guitars = guitarOwner.getGuitars();
//            List<GuitarStub> stubs = this.converter.to(guitars);
//            stub = new GuitarOwnerStub(guitarOwner.getOwnerUsername(), guitarOwner.getOwnerEmail(), stubs);
//        } catch (Exception e) {
//            LOG.info("Error occured at conversion from GuitarOwner to GuitarOwnerStub ...\n" + e.getLocalizedMessage());
//        }
//        return stub;
//    }
//    
//}
