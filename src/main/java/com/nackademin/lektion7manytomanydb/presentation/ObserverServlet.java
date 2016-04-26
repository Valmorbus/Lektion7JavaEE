/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.lektion7manytomanydb.presentation;

import com.nackademin.lektion7manytomanydb.businesslogic.Boundary;
import com.nackademin.lektion7manytomanydb.entities.Bird;
import com.nackademin.lektion7manytomanydb.entities.Observer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
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
@WebServlet(name = "ObserverServlet", urlPatterns = {"/observersfffff"})
public class ObserverServlet extends HttpServlet {

    @Inject 
    Boundary bound;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       // RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("bird/jsp");
      //  dispatcher.forward(request, response);
    
      Set<Observer> allObservers = bound.listObservers();
        request.setAttribute("allObservers", allObservers);
      request.getRequestDispatcher("observer.jsp").forward(request, response);
     
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String observername = request.getParameter("observername");
        bound.addObserver(observername);
        response.sendRedirect("observers");
        
    }
}
