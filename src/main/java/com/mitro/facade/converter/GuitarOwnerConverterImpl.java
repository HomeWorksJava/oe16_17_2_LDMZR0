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
                guitarOwner.getOwnerEmail(), guitarOwner.getOwnerPassword());
        return guitarOwnerStub;
    }

}