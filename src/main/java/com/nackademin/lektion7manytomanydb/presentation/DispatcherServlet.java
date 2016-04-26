/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.lektion7manytomanydb.presentation;

import com.nackademin.lektion7manytomanydb.businesslogic.Boundary;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author borgs_000
 */
@WebServlet(name = "DispatcherServlet", urlPatterns = {"/"})
public class DispatcherServlet extends HttpServlet {

    @Inject 
    Boundary bound;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
      
      request.setCharacterEncoding("UTF-8");
      String path = request.getServletPath();
      String forward = null;
     
     
      request.setAttribute("allBirds", bound.listBirds());
      request.setAttribute("allObservers", bound.listObservers());
      request.setAttribute("allObservation", bound.listObservations());
                            forward = "/home.jsp";
     
      request.getRequestDispatcher(forward).forward(request, response);

    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String birdname = request.getParameter("birdname");
        String observername = request.getParameter("observername");
        String comment = request.getParameter("comment");
        
        try {
        if (birdname != null){
        bound.addBird(birdname);
      
        }
        
        
        if (observername != null){
        bound.addObserver(observername);
      
        }
        
      
        if (comment != null){
            String bird = request.getParameter("birdvalue");
            String observer = request.getParameter("observersvalue");
            
            bound.addObservation(Integer.valueOf(bird), Integer.valueOf(observer), comment);
            bound.flushAll();
        }
            } catch (javax.ejb.EJBException e){
                    
                    }
       
         response.sendRedirect("home");
    }

}
