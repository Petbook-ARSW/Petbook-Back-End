package edu.eci.arsw.petbook.services.impl;

import edu.eci.arsw.petbook.model.Event;
import edu.eci.arsw.petbook.model.Goal;
import edu.eci.arsw.petbook.persistence.IEventPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.services.IEventServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

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
    public List<Goal> getAllGoals() throws PetbookServicesException {
        try {
            return ep.getAllGoals();
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
    public Event getEventXDate(Date eventdate) throws PetbookServicesException {
        try{
            return ep.getEventXDate(eventdate);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Event> getEventsTypeDonaton(boolean isDonaton) throws PetbookServicesException {
        try{
            return ep.getEventsTypeDonaton(isDonaton);
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


}
