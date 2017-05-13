/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitro.web.servlet;

import com.mitro.facade.ejbs.GuitarFacade;
import com.mitro.facade.exception.FacadeException;
import com.mitro.facade.stub.GuitarStub;
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
@WebServlet("/html/users/Guitars")
public class GuitarControllerUsers extends HttpServlet{

    private static final Logger LOGGER = Logger.getLogger(GuitarControllerUsers.class.getName());

    @EJB
    private GuitarFacade facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
            LOGGER.info("Get Guitars (in servlet)");
            List<GuitarStub> guitars = null;
            try {
                    guitars = this.facade.getGuitars();
                    request.setAttribute("guitars", guitars);
            } catch (FacadeException e) {
                    LOGGER.info("Error occured at fetching the Guitars ...\n" + e.getLocalizedMessage());
            }
            RequestDispatcher view = request.getRequestDispatcher("/html/users/listguitars.jsp");
            view.include(request, response);
    }
}
