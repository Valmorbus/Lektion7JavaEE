/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.lektion7manytomanydb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author borgs_000
 */
@Embeddable
public class ObservationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "BIRDID", nullable = false)
    private int birdid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OBSERVERID", nullable = false)
    private int observerid;

    public ObservationPK() {
    }

    public ObservationPK(int birdid, int observerid) {
        this.birdid = birdid;
        this.observerid = observerid;
    }

    public int getBirdid() {
        return birdid;
    }

    public void setBirdid(int birdid) {
        this.birdid = birdid;
    }

    public int getObserverid() {
        return observerid;
    }

    public void setObserverid(int observerid) {
        this.observerid = observerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) birdid;
        hash += (int) observerid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservationPK)) {
            return false;
        }
        ObservationPK other = (ObservationPK) object;
        if (this.birdid != other.birdid) {
            return false;
        }
        if (this.observerid != other.observerid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nackademin.lektion7manytomanydb.entities.ObservationPK[ birdid=" + birdid + ", observerid=" + observerid + " ]";
    }
    
}
