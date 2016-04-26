/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.lektion7manytomanydb.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author borgs_000
 */
@Entity
@Table(name = "OBSERVATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observation.findAll", query = "SELECT o FROM Observation o"),
    @NamedQuery(name = "Observation.findByBirdid", query = "SELECT o FROM Observation o WHERE o.observationPK.birdid = :birdid"),
    @NamedQuery(name = "Observation.findByObserverid", query = "SELECT o FROM Observation o WHERE o.observationPK.observerid = :observerid"),
    @NamedQuery(name = "Observation.findByComment", query = "SELECT o FROM Observation o WHERE o.comment = :comment")})
public class Observation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObservationPK observationPK;
    @Size(max = 256)
    @Column(name = "COMMENT", length = 256)
    private String comment;
    @JoinColumn(name = "BIRDID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bird bird;
    @JoinColumn(name = "OBSERVERID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Observer observer;

    public Observation() {
    }

    public Observation(ObservationPK observationPK) {
        this.observationPK = observationPK;
    }

    public Observation(int birdid, int observerid) {
        this.observationPK = new ObservationPK(birdid, observerid);
    }

    public ObservationPK getObservationPK() {
        return observationPK;
    }

    public void setObservationPK(ObservationPK observationPK) {
        this.observationPK = observationPK;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public Observer getObserver() {
        return observer;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observationPK != null ? observationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observation)) {
            return false;
        }
        Observation other = (Observation) object;
        if ((this.observationPK == null && other.observationPK != null) || (this.observationPK != null && !this.observationPK.equals(other.observationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nackademin.lektion7manytomanydb.entities.Observation[ observationPK=" + observationPK + " ]";
    }
    
}
