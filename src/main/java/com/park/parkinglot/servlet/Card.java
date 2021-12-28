/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.park.parkinglot.servlet;

import com.park.parkinglot.common.BonDetails;
import com.park.parkinglot.ejb.PaymentBean;
import com.park.parkinglot.ejb.ProdusBean;
import static com.park.parkinglot.servlet.PaymentDone.produse;
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
@WebServlet(name = "Card", urlPatterns = {"/Card"})
public class Card extends HttpServlet {

    private int nrBon = 0;

    @Inject
    PaymentBean paymentBean;

    @Inject
    ProdusBean produsBean;

    public static ArrayList<String> produse = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        request.setAttribute("bonId", nrBon);
//        nrBon = 0;
        request.getRequestDispatcher("/WEB-INF/pages/card.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        nrBon = paymentBean.createBon(produse);
        request.setAttribute("bonId", nrBon);

        Payment.valoare = 0;
        Payment.total = 0;
//          String bd = request.getParameter("bonId");
        int bonId = nrBon;
//        request.setAttribute("bonId", bonId);

        BonDetails bon = paymentBean.findBonById(bonId);
        double valoare = 0;
        ArrayList<com.park.parkinglot.entity.Produs> details = produsBean.findByIds(bon.getCod_bare());
        for (com.park.parkinglot.entity.Produs d : details) {
            valoare += d.getPret();
        }
        valoare = valoare - (0.15 * valoare);
        request.setAttribute("valoare", valoare);
        request.setAttribute("produse", details);
//        response.sendRedirect(request.getContextPath() + "/PaymentDone");
        produse.clear();
        request.getRequestDispatcher("/WEB-INF/pages/paymentDone.jsp").forward(request, response);

//        response.sendRedirect(request.getContextPath() + "/PaymentDone");
//        request.getRequestDispatcher("/WEB-INF/pages/paymentDone.jsp").forward(request, response);
    }
}
