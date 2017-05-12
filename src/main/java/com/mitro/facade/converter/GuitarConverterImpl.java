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

	@Override
	public GuitarStub to(Guitar guitar) {
		GuitarBrandStub guitarBrandStub = GuitarBrandStub.valueOf(guitar.getGuitarbrand().toString());
		GuitarOwnerStub guitarOwnerStub = this.converter.to(guitar.getGuitarOwner());
		return new GuitarStub(guitarBrandStub, guitar.getGuitartype(), guitar.getGuitarSerialNumber(),
				guitar.getGuitarColor(), guitar.getGuitarVintage(), guitar.getGuitarPrice(), guitarOwnerStub);
	}

    @Override
    public List<GuitarStub> to(List<Guitar> guitars) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
