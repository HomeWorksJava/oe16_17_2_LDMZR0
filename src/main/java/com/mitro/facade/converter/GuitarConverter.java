/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.facade.converter;

import com.mitro.facade.stub.GuitarStub;
import com.mitro.persistence.entities.Guitar;
import javax.ejb.Local;

/**
 *
 * @author hallgato
 */
@Local
public interface GuitarConverter {
    
    GuitarStub to(Guitar guitar);
    
}
