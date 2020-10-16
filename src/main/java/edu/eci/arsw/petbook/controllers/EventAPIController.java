package edu.eci.arsw.petbook.controllers;


import edu.eci.arsw.petbook.model.Event;
import edu.eci.arsw.petbook.model.Goal;
import edu.eci.arsw.petbook.model.Raffle;
import edu.eci.arsw.petbook.services.IEventServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin(origins = "*")
public class EventAPIController {

    @Autowired
    IEventServices es;

    @RequestMapping(path = "/events/newEvent", method = RequestMethod.POST)
    public ResponseEntity<?> postEvent(@RequestBody Event event){
        try {
            es.addEvent(event);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }

    @RequestMapping(path = "/events/{eventId}/newGoal", method = RequestMethod.POST)
    public ResponseEntity<?> postGoal(@PathVariable(name = "eventId") int eventId, @RequestBody Goal goal){
        try {
            es.addGoal(goal);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }

    @RequestMapping(path = "/events", method = RequestMethod.GET)
    public ResponseEntity<?> getAllEvents(){
        try{
            return new ResponseEntity<>(es.getAllEvents(),HttpStatus.ACCEPTED);
        }catch (PetbookServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/events/{eventId}/goals", method = RequestMethod.GET)
    public ResponseEntity<?> getGoalsXEventId(@PathVariable(name = "eventId") int eventId){
        try{
            return new ResponseEntity<>(es.getAllGoals(eventId),HttpStatus.ACCEPTED);
        }catch (PetbookServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/events/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEventXId(@PathVariable(name = "id") int id) {
        try {
            return new ResponseEntity<>(es.getEventXId(id), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "host/events/{hostcompany}", method = RequestMethod.GET)
    public ResponseEntity<?> getEventsXHost(@PathVariable(name = "hostcompany") int hostcompany) {
        try {
            return new ResponseEntity<>(es.getEventsXHost(hostcompany), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "date/events/{eventdate}", method = RequestMethod.GET)
    public ResponseEntity<?> getEventXDate(@PathVariable(name = "eventdate") Date eventdate) {
        try {
            return new ResponseEntity<>(es.getEventsXDate(eventdate), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "donaton/events/{isDonaton}", method = RequestMethod.GET)
    public ResponseEntity<?> getEventsXDonaton(@PathVariable(name = "isDonaton") boolean isDonaton) {
        try {
            return new ResponseEntity<>(es.getEventsTypeDonaton(), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "deleteEvent/events/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeEvent(@PathVariable(name = "id") int id) {
        try {
            es.removeEventXId(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "updateEvent/events/", method = RequestMethod.POST)
    public ResponseEntity<?> UpdateEvent(@RequestBody Event event) {
        try {
            es.updateEvent(event);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/events/{eventId}/goals/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getGoalsXId(@PathVariable(name = "id") int id){
        try{
            return new ResponseEntity<>(es.getGoalsXId(id),HttpStatus.ACCEPTED);
        }catch (PetbookServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/events/{eventId}/{goalId}/newRaffle", method = RequestMethod.POST)
    public ResponseEntity<?> postRaffle(@PathVariable(name = "eventId") int eventId,@PathVariable(name = "goalId") int goalId, @RequestBody Raffle raffle){
        try {
            es.addRaffle(raffle);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }

    @RequestMapping(path = "/events/{eventId}/raffles", method = RequestMethod.GET)
    public ResponseEntity<?> getRafflesXEventId(@PathVariable(name = "eventId") int eventId){
        try{
            return new ResponseEntity<>(es.getAllRaffles(eventId),HttpStatus.ACCEPTED);
        }catch (PetbookServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/events/{eventId}/raffles/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRafflesXId(@PathVariable(name = "id") int id){
        try{
            return new ResponseEntity<>(es.getRafflesXId(id),HttpStatus.ACCEPTED);
        }catch (PetbookServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "deleteGoal/events/goals/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeGoal(@PathVariable(name = "id") int id) {
        try {
            es.removeGoalXId(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "updateGoal/events/goals", method = RequestMethod.POST)
    public ResponseEntity<?> UpdateGoal(@RequestBody Goal goal) {
        try {
            es.updateGoal(goal);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/events/{idevent}/participants", method = RequestMethod.GET)
    public ResponseEntity<?> getParticipantsXEventId(@PathVariable(name = "idevent") int idevent){
        try{
            return new ResponseEntity<>(es.getParticipantsXEvento(idevent),HttpStatus.ACCEPTED);
        }catch (PetbookServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
