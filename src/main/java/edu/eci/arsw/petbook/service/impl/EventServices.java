package edu.eci.arsw.petbook.service.impl;

import edu.eci.arsw.petbook.model.Event;
import edu.eci.arsw.petbook.model.Goal;
import edu.eci.arsw.petbook.model.Participant;
import edu.eci.arsw.petbook.model.Raffle;
import edu.eci.arsw.petbook.persistence.IEventPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.service.IEventServices;
import edu.eci.arsw.petbook.service.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Collections;

@Service
public class EventServices implements IEventServices {

    @Autowired
    IEventPersistence ep;

    public EventServices(){}

    @Override
    public void addEvent(Event event) throws PetbookServicesException {
        try {
            ep.addEvent(event);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Event> getAllEvents() throws PetbookServicesException {
        try {
            return ep.getAllEvents();
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void addGoal(Goal goal) throws PetbookServicesException {
        try {
            ep.addGoal(goal);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Goal> getAllGoals(int eventid) throws PetbookServicesException {
        try {
            return ep.getAllGoals(eventid);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public Event getEventXId(int id) throws PetbookServicesException {
        try{
            return ep.getEventXId(id);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Event> getEventsXHost(int hostcompany) throws PetbookServicesException {
        try{
            return ep.getEventsXHost(hostcompany);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Event> getEventsXDate(Date eventdate) throws PetbookServicesException {
        try{
            return ep.getEventsXDate(eventdate);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Event> getEventsTypeDonaton() throws PetbookServicesException {
        try{
            return ep.getEventsTypeDonaton();
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void removeEventXId(int id) throws PetbookServicesException {
        try {
            ep.removeEventXId(id);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void updateEvent(Event evento) throws PetbookServicesException {
        try {
            ep.updateEvent(evento);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public Goal getGoalsXId(int id) throws PetbookServicesException {
        try {
            return ep.getGoalsXId(id);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void addRaffle(Raffle raffle) throws PetbookServicesException {
        try {
            ep.addRaffle(raffle);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Raffle> getAllRaffles(int eventid) throws PetbookServicesException {
        try {
            return ep.getAllRaffles(eventid);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public Raffle getRafflesXId(int id) throws PetbookServicesException {
        try {
            return ep.getRafflesXId(id);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void removeGoalXId(int id) throws PetbookServicesException {
        try {
            ep.removeGoalXId(id);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void updateGoal(Goal goal) throws PetbookServicesException {
        try {
            ep.updateGoal(goal);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Participant> getParticipantsXEvento(int idevent) throws PetbookServicesException {
        try {
            return ep.getParticipantsXEvento(idevent);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }
    
    @Override
    public int getAllValueGoals(int eventid) throws PetbookServicesException {
        try {
            List<Goal> metas = ep.getAllGoals(eventid);
            
            int valor = 0;
            for (Goal i: metas){
                if(valor < i.getValor()){
                    valor = i.getValor();
                }
            }
            return valor;
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }
}
