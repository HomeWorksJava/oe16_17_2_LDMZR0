/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.persistence.service;

import com.mitro.persistence.entities.GuitarOwner;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.PersistenceException;

/**
 *
 * @author hallgato
 */
@Local
public interface ManiacService {
    
    List<GuitarOwner> readAllManiacs() throws PersistenceException;
    
}
