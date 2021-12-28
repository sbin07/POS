/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.park.parkinglot.servlet;

import com.park.parkinglot.common.BonDetails;
import com.park.parkinglot.ejb.PaymentBean;
import com.park.parkinglot.ejb.ProdusBean;
import static com.park.parkinglot.servlet.Payment.total;
import static com.park.parkinglot.servlet.Payment.valoare;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

/**
 *
 * @author mihal
 */
@WebServlet(name = "Cash", urlPatterns = {"/Cash"})
public class Cash extends HttpServlet {

    private int nrBon = 0;

    @Inject
    PaymentBean paymentBean;

    @Inject
    ProdusBean produsBean;

    public static ArrayList<String> produse = new ArrayList<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("total", Payment.total);

        request.getRequestDispatcher("/WEB-INF/pages/cash.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        nrBon = paymentBean.createBon(produse);
        request.setAttribute("bonId", nrBon);

        int bonId = nrBon;

        BonDetails bon = paymentBean.findBonById(bonId);
        double valoare = 0;
        ArrayList<com.park.parkinglot.entity.Produs> details = produsBean.findByIds(bon.getCod_bare());
//        for (com.park.parkinglot.entity.Produs d : details) {
//            valoare += d.getPret();
//        }
//        valoare = valoare - (0.15 * valoare);
        request.setAttribute("total", Payment.total);
        request.setAttribute("produse", details);

        String input = request.getParameter("de_introdus");
        double rest = Double.parseDouble(input) - Payment.total;
        if (rest < 0) {
            throw new ValidationException("Valoarea introdusa este prea mica");
        }
        request.setAttribute("rest", df.format(rest));
        Payment.valoare = 0;
        Payment.total = 0;
        produse.clear();
        request.getRequestDispatcher("/WEB-INF/pages/paymentDone.jsp").forward(request, response);

    }
}
