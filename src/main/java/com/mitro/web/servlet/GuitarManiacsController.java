/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.web.servlet;

import com.mitro.facade.ejbs.GuitarFacade;
import com.mitro.facade.ejbs.OwnerFacade;
import com.mitro.facade.exception.FacadeException;
import com.mitro.facade.stub.GuitarOwnerStub;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hallgato
 */
@WebServlet("/html/admin/Maniacs")
public class GuitarManiacsController extends HttpServlet{
    
    @EJB
    private OwnerFacade facade;
    
    private static final Logger LOGGER = Logger.getLogger(GuitarManiacsController.class.getName());
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
            LOGGER.info("Get owners of guitars");
            List<GuitarOwnerStub> owners = null;
            try {
                    owners = this.facade.getManiacs();
                    request.setAttribute("maniacs", owners);
            } catch (FacadeException e) {
                    LOGGER.info("Error occured at fetching the Owners ...\n" + e.getLocalizedMessage());
            }
            RequestDispatcher view = request.getRequestDispatcher("/html/admin/listmaniacs.jsp");
            view.include(request, response);
    }
    
}
