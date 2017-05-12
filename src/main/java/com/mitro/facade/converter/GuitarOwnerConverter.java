/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.converter;

import com.mitro.facade.stub.GuitarOwnerStub;
import com.mitro.persistence.entities.GuitarOwner;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hallgato
 */
@Local
public interface GuitarOwnerConverter {
    
    GuitarOwnerStub to(GuitarOwner guitarOwner);
    List<GuitarOwnerStub> to(List<GuitarOwner> guitarOwners);
}
