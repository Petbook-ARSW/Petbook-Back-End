package edu.eci.arsw.petbook.services;

import edu.eci.arsw.petbook.model.Event;
import edu.eci.arsw.petbook.model.Goal;

import java.sql.Date;
import java.util.List;

public interface IEventServices {

    void addEvent(Event event)throws PetbookServicesException;

    List<Event> getAllEvents()throws PetbookServicesException;

    void addGoal(Goal goal)throws PetbookServicesException;

    List<Goal> getAllGoals(int eventid)throws PetbookServicesException;

    Event getEventXId(int id) throws PetbookServicesException;

    List<Event> getEventsXHost(int hostcompany) throws PetbookServicesException;

    Event getEventXDate(Date eventdate)throws PetbookServicesException;

    List<Event> getEventsTypeDonaton(boolean isDonaton)throws PetbookServicesException;

    void removeEventXId(int id) throws PetbookServicesException;

    void updateEvent(Event evento) throws PetbookServicesException;

    Goal getGoalsXId(int id)throws PetbookServicesException;
}
