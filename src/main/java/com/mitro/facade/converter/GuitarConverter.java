/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.converter;

import com.mitro.facade.stub.GuitarStub;
import com.mitro.persistence.entities.Guitar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hallgato
 */
@Local
public interface GuitarConverter {
    
    public GuitarStub to(Guitar guitar);
    public List<GuitarStub> to(List<Guitar> guitars);
    
}
