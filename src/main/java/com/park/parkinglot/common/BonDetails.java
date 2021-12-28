/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.park.parkinglot.common;

import java.util.Collection;


/**
 *
 * @author sabin
 */
public class BonDetails implements java.io.Serializable {

    private Integer id;

    private java.util.Collection<String> cod_bare;

     public BonDetails() {
        
    }
    
    public BonDetails(Integer id, Collection<String> cod_bare) {
        this.id = id;
        this.cod_bare = cod_bare;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.util.Collection<String> getCod_bare() {
        return cod_bare;
    }

    public void setCod_bare(java.util.Collection<String> cod_bare) {
        this.cod_bare = cod_bare;
    }

}
