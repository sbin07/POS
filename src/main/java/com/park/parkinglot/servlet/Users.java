/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.park.parkinglot.servlet;


import com.park.parkinglot.common.CarDetails;
import com.park.parkinglot.common.UserDetails;
import com.park.parkinglot.ejb.UserBean;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mihal
 */
@WebServlet(name = "Users", urlPatterns = {"/Users"})
public class Users extends HttpServlet{
    @Inject
    private UserBean userBean;
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request,response);
        request.setAttribute("activePage", "Users");
        request.setAttribute("numberOfFreeParkingSpots", 10);

        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("users", users);

        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
    }
}
