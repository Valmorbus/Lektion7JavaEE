/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.lektion7manytomanydb.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author borgs_000
 */
@Entity
@Table(name = "OBSERVER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observer.findAll", query = "SELECT o FROM Observer o"),
    @NamedQuery(name = "Observer.findById", query = "SELECT o FROM Observer o WHERE o.id = :id"),
    @NamedQuery(name = "Observer.findByObservername", query = "SELECT o FROM Observer o WHERE o.observername = :observername")})
public class Observer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false, fetch=EAGER)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "OBSERVERNAME", nullable = false, length = 256)
    private String observername;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observer")
    private Set<Observation> observationSet;

    public Observer() {
    }

    public Observer(Integer id) {
        this.id = id;
    }

    public Observer(Integer id, String observername) {
        this.id = id;
        this.observername = observername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservername() {
        return observername;
    }

    public void setObservername(String observername) {
        this.observername = observername;
    }

    @XmlTransient
    public Set<Observation> getObservationSet() {
        return observationSet;
    }

    public void setObservationSet(Set<Observation> observationSet) {
        this.observationSet = observationSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observer)) {
            return false;
        }
        Observer other = (Observer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nackademin.lektion7manytomanydb.entities.Observer[ id=" + id + " ]";
    }
    
}
