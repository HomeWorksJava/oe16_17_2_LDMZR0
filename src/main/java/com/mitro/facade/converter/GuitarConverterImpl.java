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
import java.util.logging.Logger;
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

}