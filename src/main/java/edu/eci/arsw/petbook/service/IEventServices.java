package edu.eci.arsw.petbook.service;

import edu.eci.arsw.petbook.model.Event;
import edu.eci.arsw.petbook.model.Goal;
import edu.eci.arsw.petbook.model.Participant;
import edu.eci.arsw.petbook.model.Raffle;

import java.sql.Date;
import java.util.List;

public interface IEventServices {

    void addEvent(Event event)throws PetbookServicesException;

    List<Event> getAllEvents()throws PetbookServicesException;

    void addGoal(Goal goal)throws PetbookServicesException;

    List<Goal> getAllGoals(int eventid)throws PetbookServicesException;

    Event getEventXId(int id) throws PetbookServicesException;

    List<Event> getEventsXHost(int hostcompany) throws PetbookServicesException;

    List<Event> getEventsXDate(Date eventdate)throws PetbookServicesException;

    List<Event> getEventsTypeDonaton()throws PetbookServicesException;

    void removeEventXId(int id) throws PetbookServicesException;

    void updateEvent(Event evento) throws PetbookServicesException;

    Goal getGoalsXId(int id)throws PetbookServicesException;

    void addRaffle(Raffle raffle)throws PetbookServicesException;

    List<Raffle> getAllRaffles(int eventid)throws PetbookServicesException;

    Raffle getRafflesXId(int id)throws PetbookServicesException;

    void removeGoalXId(int id) throws PetbookServicesException;

    void updateGoal(Goal goal) throws PetbookServicesException;

    List<Participant> getParticipantsXEvento(int idevent)throws PetbookServicesException;
}
