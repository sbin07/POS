/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.park.parkinglot.common;

/**
 *
 * @author sabin
 */
public class ProdusDetails implements java.io.Serializable {

    private String barCode;
    private String denumire;
    private double pret;

    public ProdusDetails(String barCode, String denumire, double pret) {
        this.barCode = barCode;
        this.denumire = denumire;
        this.pret = pret;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getDenumire() {
        return denumire;
    }

    public double getPret() {
        return pret;
    }

}
