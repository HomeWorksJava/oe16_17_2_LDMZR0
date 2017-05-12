/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.persistence.service;

import com.mitro.persistence.entities.Guitar;
import com.mitro.persistence.entities.GuitarBrand;
import com.mitro.persistence.entities.GuitarOwner;
import com.mitro.persistence.parameter.GuitarParameter;
import com.mitro.persistence.parameter.OwnerParameter;
import com.mitro.persistence.query.GuitarQuery;
import com.mitro.persistence.query.OwnerQuery;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author Mitró Tamás
 */
@Stateless(mappedName = "/ejb/guitarService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class GuitarServiceImpl implements GuitarService {

    private static final Logger LOGGER = Logger.getLogger(GuitarServiceImpl.class.getName());

    @PersistenceContext(name = "GuitarManiaPU")
    private EntityManager entityManager;

    @Override
    public Guitar read(Long id) throws PersistenceException {
            LOGGER.info("Find a guitar by id.");
            Guitar guitar = null;
            try {
                    guitar = this.entityManager.createNamedQuery(GuitarQuery.GET_BY_ID, Guitar.class)
                                    .setParameter(GuitarParameter.ID, id).getSingleResult();
            } catch (Exception e) {
                    throw new PersistenceException("Unknown error when fetching Guitar by id (" + id + ")!" + e.getLocalizedMessage(), e);
            }
            return guitar;
    }

    @Override
    public Guitar readBySerialNumber(String serialNumber) throws PersistenceException {
            LOGGER.info("Find a guitar by serial number.");
            Guitar guitar = null;
            try {
                    guitar = this.entityManager.createNamedQuery(GuitarQuery.GET_BY_SERIALNUMBER, Guitar.class)
                                    .setParameter(GuitarParameter.SERIALNUMBER, serialNumber).getSingleResult();
            } catch (Exception e) {
                    throw new PersistenceException("Unknown error when fetching Guitar by serialNumber (" + serialNumber + ")!"
                                    + e.getLocalizedMessage(), e);
            }
            return guitar;
    }

    @Override
    public List<Guitar> readAll() throws PersistenceException {
            LOGGER.info("List all of guitars.");
            List<Guitar> guitars = this.entityManager.createNamedQuery(GuitarQuery.GET_ALL, Guitar.class).getResultList();
            return guitars;
    }

    @Override
    public void insertGuitar(String guitarBrand, String guitarType, String color, String serialNumber, Integer vintage,
                    double price, String ownername) throws PersistenceException {
            LOGGER.info("Add a guitar to the database.");
            Guitar guitar = null;
            try {
                    GuitarOwner owner = this.entityManager.createNamedQuery(OwnerQuery.OWNER_BY_NAME, GuitarOwner.class)
                                    .setParameter(OwnerParameter.OWNERNAME, ownername).getSingleResult();
                    if (owner == null) {
                            LOGGER.info("Error caused at insert of guitar, the given owner does not exist!");
                            throw new PersistenceException("Error caused at insert of guitar, the given owner does not exist!");
                    }
                    GuitarBrand brand = GuitarBrand.valueOf(guitarBrand);
                    guitar = new Guitar(brand, serialNumber, guitarType, color, vintage, price, owner);
                    this.entityManager.merge(guitar);
            } catch (Exception e) {
                    LOGGER.info("Unknown error caused at insert of guitar!");
                    throw new PersistenceException("Unknown error caused at insert of guitar. " + e.getLocalizedMessage());
            }
    }

    @Override
    public List<Guitar> readByOwner(String owner) throws PersistenceException {
        LOGGER.info("Get guitars of owner.");
        List<Guitar> guitars = null;
        try {
            GuitarOwner ownerentity = this.entityManager.createNamedQuery(OwnerQuery.OWNER_BY_NAME, GuitarOwner.class)
                                    .setParameter(OwnerParameter.OWNERNAME, owner).getSingleResult();
            if (ownerentity == null) {
                LOGGER.info("Error caused at insert of guitar, the given owner does not exist!");
                throw new PersistenceException("Error caused at insert of guitar, the given owner does not exist!");
            }
            guitars = this.entityManager.createNamedQuery(GuitarQuery.GET_BY_OWNERNAME, Guitar.class)
                    .setParameter(GuitarParameter.OWNERNAME, owner).getResultList();
        } catch (Exception e) {
        }
        return guitars;
    }

}
