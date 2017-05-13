/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.persistence.service;

/**
 *
 * @author Mitró Tamás
 */
import java.util.List;
import javax.ejb.Local;
import javax.persistence.PersistenceException;
import com.mitro.persistence.entities.Guitar;

@Local
public interface GuitarService {

	Guitar read(Long id) throws PersistenceException;

	Guitar readBySerialNumber(String serialNumber) throws PersistenceException;
        
        List<Guitar> readByOwner(String owner) throws PersistenceException;

	List<Guitar> readAll() throws PersistenceException;

	void insertGuitar(String guitarBrand, String guitarType, String color, String serialNumber, Integer vintage,
			double price, String ownername) throws PersistenceException;
}
