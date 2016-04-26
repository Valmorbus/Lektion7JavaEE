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
@Table(name = "BIRD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bird.findAll", query = "SELECT b FROM Bird b"),
    @NamedQuery(name = "Bird.findById", query = "SELECT b FROM Bird b WHERE b.id = :id"),
    @NamedQuery(name = "Bird.findByBirdname", query = "SELECT b FROM Bird b WHERE b.birdname = :birdname")})
public class Bird implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false, fetch=EAGER)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "BIRDNAME", nullable = false, length = 256)
    private String birdname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bird")
    private Set<Observation> observationSet;

    public Bird() {
    }

    public Bird(Integer id) {
        this.id = id;
    }

    public Bird(Integer id, String birdname) {
        this.id = id;
        this.birdname = birdname;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBirdname() {
        return birdname;
    }

    public void setBirdname(String birdname) {
        this.birdname = birdname;
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
        if (!(object instanceof Bird)) {
            return false;
        }
        Bird other = (Bird) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nackademin.lektion7manytomanydb.entities.Bird[ id=" + id + " ]";
    }
    
}
