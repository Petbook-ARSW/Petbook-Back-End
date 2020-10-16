package edu.eci.arsw.petbook.persistence;

import edu.eci.arsw.petbook.model.Event;
import edu.eci.arsw.petbook.model.Goal;
import edu.eci.arsw.petbook.model.Participant;
import edu.eci.arsw.petbook.model.Raffle;

import java.sql.Date;
import java.util.List;

public interface IEventPersistence {

    void addEvent(Event event) throws PetbookPersistenceException;

    List<Event> getAllEvents() throws PetbookPersistenceException;

    void addGoal(Goal goal) throws PetbookPersistenceException;

    List<Goal> getAllGoals(int eventid) throws PetbookPersistenceException;

    Event getEventXId(int id) throws PetbookPersistenceException;

    List<Event> getEventsXHost(int hostcompany) throws PetbookPersistenceException;

    Event getEventXDate(Date eventdate) throws PetbookPersistenceException;

    List<Event> getEventsTypeDonaton(boolean isDonaton) throws PetbookPersistenceException;


    void removeEventXId(int id) throws PetbookPersistenceException;

    void updateEvent(Event evento) throws PetbookPersistenceException;

    void saveEvent(Event evento) throws PetbookPersistenceException;

    Goal getGoalsXId(int id) throws PetbookPersistenceException;

    void addRaffle(Raffle raffle) throws PetbookPersistenceException;;

    List<Raffle> getAllRaffles(int eventid) throws PetbookPersistenceException;

    Raffle getRafflesXId(int id) throws PetbookPersistenceException;

    void removeGoalXId(int id) throws PetbookPersistenceException;

    void updateGoal(Goal goal) throws PetbookPersistenceException;

    void saveGoal(Goal goal) throws PetbookPersistenceException;

    List<Participant> getParticipantsXEvento(int idevent)throws PetbookPersistenceException;
}
