/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.park.parkinglot.servlet;

import com.park.parkinglot.ejb.PaymentBean;
import com.park.parkinglot.ejb.ProdusBean;
import static com.park.parkinglot.servlet.Card.produse;
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
 * @author mihal
 */
@WebServlet(name = "PaymentDone", urlPatterns = {"/PaymentDone"})
public class PaymentDone extends HttpServlet {

    @Inject
    PaymentBean paymentBean;

    @Inject
    ProdusBean produsBean;

    public static ArrayList<String> produse = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
      
    }
}
