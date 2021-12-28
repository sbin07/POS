/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.park.parkinglot.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

/**
 *
 * @author mihaILUT
 */
@Entity
@Table(name = "PRODUS")
public class Produs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String cod_bare;

    private String denumire;

    private double pret;

    public String getCodBare() {
        return cod_bare;
    }

    public void setCodBare(String codBare) {
        this.cod_bare = codBare;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produs other = (Produs) obj;
        if (!Objects.equals(this.cod_bare, other.cod_bare)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.park.parkinglot.entity.Produs[ codBare=" + cod_bare + " ]";
    }

}
