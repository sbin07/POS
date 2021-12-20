/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.park.parkinglot.servlet;

import com.park.parkinglot.common.CarDetails;
import com.park.parkinglot.common.ProdusDetails;
import com.park.parkinglot.ejb.CarBean;
import com.park.parkinglot.ejb.ProdusBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sabin
 *
 */
@WebServlet(name = "Payment", urlPatterns = {"/Payment"})
public class Payment extends HttpServlet {

    @Inject
    ProdusBean produsBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("sal");
        String produsCod = request.getParameter("cod_produs");
        System.out.println(produsCod);

        ProdusDetails produs = produsBean.findById("123");
        System.out.println("sal");
        request.setAttribute("produs", produs);

        request.getRequestDispatcher("/WEB-INF/pages/payment.jsp").forward(request, response);
    }
}
