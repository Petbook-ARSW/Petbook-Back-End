package edu.eci.arsw.petbook.persistence;

import edu.eci.arsw.petbook.model.Event;
import edu.eci.arsw.petbook.model.Goal;

import java.sql.Date;
import java.util.List;

public interface IEventPersistence {

    void addEvent(Event event)throws PetbookPersistenceException;

    List<Event> getAllEvents()throws PetbookPersistenceException;

    void addGoal(Goal goal)throws PetbookPersistenceException;

    List<Goal> getAllGoals()throws PetbookPersistenceException;

    Event getEventXId(int id) throws PetbookPersistenceException;

    List<Event> getEventsXHost(int hostcompany) throws PetbookPersistenceException;

    Event getEventXDate(Date eventdate)throws PetbookPersistenceException;

    List<Event> getEventsTypeDonaton(boolean isDonaton)throws PetbookPersistenceException;
}
