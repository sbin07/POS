
package com.park.parkinglot.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sbin
 */
@Entity
@Table(name = "BON")
public class Bon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String codBare;

    @OneToMany(mappedBy = "bon")
    private Collection<Produs> produse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodBare() {
        return codBare;
    }

    public void setCodBare(String codBare) {
        this.codBare = codBare;
    }

    public Collection<Produs> getProduse() {
        return produse;
    }

    public void setProduse(Collection<Produs> produse) {
        this.produse = produse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
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
        final Bon other = (Bon) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.park.parkinglot.entity.Bon[ id=" + id + " ]";
    }

}
