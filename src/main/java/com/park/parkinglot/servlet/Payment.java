/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.park.parkinglot.servlet;

import com.park.parkinglot.common.ProdusDetails;
import com.park.parkinglot.ejb.ProdusBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    private List<ProdusDetails> productDetails = new ArrayList<>();
    public static double valoare = 0;
    private double discount = 0.15;
    public static double total = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("valoare", valoare);

        request.setAttribute("total", total);

        request.getRequestDispatcher("/WEB-INF/pages/payment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.getRequestDispatcher("/WEB-INF/pages/addCar.jsp").forward(request, response);
        String produsCod = request.getParameter("cod_produs");
        Card.produse.add(produsCod);
        ProdusDetails produs = produsBean.findById(produsCod);

        productDetails.add(produs);
        request.setAttribute("items", productDetails);

        valoare += produs.getPret();
        total = valoare - (valoare * discount);

        request.setAttribute("valoare", valoare);

        request.setAttribute("total", total);

        request.getRequestDispatcher("/WEB-INF/pages/payment.jsp").forward(request, response);

//        response.sendRedirect(request.getContextPath() + "/Payment");
    }
}
