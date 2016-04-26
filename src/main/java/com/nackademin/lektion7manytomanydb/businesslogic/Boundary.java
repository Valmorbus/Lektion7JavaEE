/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.lektion7manytomanydb.businesslogic;

import com.nackademin.lektion7manytomanydb.entities.Bird;
import com.nackademin.lektion7manytomanydb.entities.Observation;
import com.nackademin.lektion7manytomanydb.entities.Observer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author borgs_000
 */
@Stateless
public class Boundary {

    @Inject
    BirdFacade birdfacade;

    @Inject
    ObserverFacade observerfacade;

    @Inject
    ObservationFacade observationfacade;

    public void addBird(Bird bird) {
        birdfacade.create(bird);
    }

    public void addBird(String birdname) {
        Bird bird = new Bird();
        bird.setBirdname(birdname);
        birdfacade.create(bird);
    }

    public Set<Bird> listBirds() {
        Set<Bird> birdSet = new HashSet<Bird>();
        birdSet.addAll(birdfacade.findAll());
        return birdSet;
    }
    
    
    public List<Bird> getAllBirdsInAlphabeticalOrder(){
        return (List<Bird>) new TreeSet(birdfacade.findAll());
    }
       

    public void addObserver(Observer observer) {
        observerfacade.create(observer);
    }

    public void addObserver(String observername) {
       Observer observer = new Observer();
       observer.setObservername(observername);
        addObserver(observer);
       
    }
    
    public Set<Observer> listObservers(){
        Set<Observer> obsSet = new HashSet<Observer>();
        obsSet.addAll(observerfacade.findAll());
        return obsSet;
    }
    
    public void addObservation(int birdid, int observerid, String comment){
        Observation observation = new Observation(birdid, observerid);
      //  observation.setBird(birdfacade.find(birdid));
      //  observation.setObserver(observerfacade.find(observerid));
        observation.setComment(comment);
        observationfacade.create(observation);
    }

    public Object listObservations() {
       return observationfacade.findAll();
    }
    
    
    public void flushAll(){
        observationfacade.getEntityManager().flush();
        observerfacade.getEntityManager().flush();
        birdfacade.getEntityManager().flush();
    }

}
