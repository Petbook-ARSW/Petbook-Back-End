package edu.eci.arsw.petbook.controllers;


import edu.eci.arsw.petbook.model.Event;
import edu.eci.arsw.petbook.model.Goal;
import edu.eci.arsw.petbook.services.IEventServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/home")
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
    public ResponseEntity<?> postEvent(@PathVariable(name = "eventId") int eventId, @RequestBody Goal goal){
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
    public ResponseEntity<?> getAllGoals(@PathVariable(name = "eventId") int eventId){
        try{
            return new ResponseEntity<>(es.getAllGoals(),HttpStatus.ACCEPTED);
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
            return new ResponseEntity<>(es.getEventXDate(eventdate), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "donaton/events/{isDonaton}", method = RequestMethod.GET)
    public ResponseEntity<?> getEventsXHost(@PathVariable(name = "isDonaton") boolean isDonaton) {
        try {
            return new ResponseEntity<>(es.getEventsTypeDonaton(isDonaton), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
