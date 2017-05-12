/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.rest.service;

import com.mitro.facade.stub.GuitarInputStub;
import com.mitro.facade.stub.GuitarStub;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author hallgato
 */
@Path("/guitar")
public interface GuitarRestService {

	@GET
	@Path("/id/{id}")
	@Produces("application/json")
	GuitarStub getGuitar(@PathParam("id") Long id);

	@GET
	@Path("/serial/{serial}")
	@Produces("application/json")
	GuitarStub getGuitar(@PathParam("serial") String serialNumber);

	@GET
	@Path("/list")
	@Produces("application/json")
	List<GuitarStub> getAllGuitars();

	@PUT
	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
	void addGuitarStub(GuitarInputStub guitar);

}
