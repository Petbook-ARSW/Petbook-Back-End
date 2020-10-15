package edu.eci.arsw.petbook.persistence.impl;

import edu.eci.arsw.petbook.model.Event;
import edu.eci.arsw.petbook.model.Goal;
import edu.eci.arsw.petbook.model.Raffle;
import edu.eci.arsw.petbook.persistence.IEventPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.persistence.repo.IEventRepo;
import edu.eci.arsw.petbook.persistence.repo.IGoalRepo;
import edu.eci.arsw.petbook.persistence.repo.IRaffleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

@Repository
public class EventPersistenceImpl implements IEventPersistence {

    @Autowired
    IEventRepo er;

    @Autowired
    IGoalRepo gr;

    @Autowired
    IRaffleRepo rr;

    @PersistenceContext
    EntityManager entityManager;

    public EventPersistenceImpl(){}

    @Override
    public void addEvent(Event event) throws PetbookPersistenceException {
        try {
            er.save(event);
        }catch(Exception e){
            throw new PetbookPersistenceException("Failed to create event");
        }
    }

    @Override
    public List<Event> getAllEvents() throws PetbookPersistenceException {
        if(er.count() == 0){
            throw new PetbookPersistenceException("Events not found");
        }
        return er.findAll();
    }

    @Override
    public void addGoal(Goal goal) throws PetbookPersistenceException {
        try {
            gr.save(goal);
        }catch(Exception e) {
            throw new PetbookPersistenceException("Failed to create goal");
        }
    }

    @Override
    public List<Goal> getAllGoals(int eventid) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from goal where eventid=?",Goal.class);
        query.setParameter(1, eventid);
        if(query.getResultList().size() == 0){
            throw new PetbookPersistenceException("Goals not found");
        }
        return query.getResultList();
    }


    @Override
    public Event getEventXId(int id) throws PetbookPersistenceException{
        Query query = entityManager.createNativeQuery("select * from companyevent where id=?",Event.class);
        query.setParameter(1, id);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Event not found");
        }
        return (Event) query.getSingleResult();
    }

    @Override
    public List<Event> getEventsXHost(int hostcompany) throws PetbookPersistenceException{
        Query query = entityManager.createNativeQuery("select * from companyevent where hostcompany=?",Event.class);
        query.setParameter(1, hostcompany);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Events not found");
        }
        return query.getResultList();
    }

    @Override
    public Event getEventXDate(Date eventdate) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from companyevent where eventdate=?",Event.class);
        query.setParameter(1, eventdate);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Event not found");
        }
        return (Event) query.getSingleResult();
    }

    @Override
    public List<Event> getEventsTypeDonaton(boolean isDonaton)throws PetbookPersistenceException{
        Query query = entityManager.createNativeQuery("select * from companyevent where isDonaton=?",Event.class);
        query.setParameter(1, isDonaton);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Events not found");
        }
        return query.getResultList();
    }

    @Override
    public void removeEventXId(int id) throws PetbookPersistenceException {
        try {
            er.delete(id);
        }catch(Exception e){
            throw new PetbookPersistenceException("Failed to remove event");
        }

    }

    @Override
    public void updateEvent(Event evento) throws PetbookPersistenceException {
        try{
            Event temp = er.findOne(evento.getId());
            if (!evento.getDate().equals("")){
                temp.setDate(evento.getDate());
            }
            if (!evento.getAddress().equals("")){
                temp.setAddress(evento.getAddress());
            }
            if (!evento.getHour().equals("")){
                temp.setHour(evento.getHour());
            }
            if (!evento.getInformation().equals("")){
                temp.setInformation(evento.getInformation());
            }
            saveEvent(temp);
        }catch(Exception e){
            throw new PetbookPersistenceException("Failed to update event");
        }

    }

    @Override
    public void saveEvent(Event evento) throws PetbookPersistenceException {
        er.save(evento);
    }

    @Override
    public Goal getGoalsXId(int id) throws PetbookPersistenceException{
        Query query = entityManager.createNativeQuery("select * from goal where id=?",Goal.class);
        query.setParameter(1, id);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Goal not found");
        }
        return (Goal) query.getSingleResult();
    }

    @Override
    public void addRaffle(Raffle raffle) throws PetbookPersistenceException {
        try {
            rr.save(raffle);
        }catch(Exception e) {
            throw new PetbookPersistenceException("Failed to create goal");
        }
    }

    @Override
    public List<Raffle> getAllRaffles(int eventid) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from raffle where eventid=?",Raffle.class);
        query.setParameter(1, eventid);
        if(query.getResultList().size() == 0){
            throw new PetbookPersistenceException("Raffles not found");
        }
        return query.getResultList();
    }

    @Override
    public Raffle getRafflesXId(int id) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from raffle where id=?",Raffle.class);
        query.setParameter(1, id);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Raffle not found");
        }
        return (Raffle) query.getSingleResult();
    }

}