package edu.eci.arsw.petbook.controllers;

import edu.eci.arsw.petbook.model.User;
import edu.eci.arsw.petbook.services.IUserServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "*")
public class UserAPIController {

    @Autowired
    IUserServices us;



    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getResorces(){
        return new ResponseEntity<>(null,HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/users/newUser", method = RequestMethod.POST)
    public ResponseEntity<?> postUsuario(@RequestBody User user){
        try {
            us.addUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }

    @RequestMapping(path = "/users/participInEnvent/{idevent}/{iduser}", method = RequestMethod.POST)
    public ResponseEntity<?> postParticpation(@PathVariable(name = "idevent") int idevent,@PathVariable(name = "iduser") int iduser){
        try {
            us.asistirEvento(idevent,iduser);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }

    @RequestMapping(path = "/users/setUser", method = RequestMethod.PUT)
    public ResponseEntity<?> setUser(@RequestBody User user) {
        try {
            us.setUser(user);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers(){
        try{
            return new ResponseEntity<>(us.getAllUsers(),HttpStatus.ACCEPTED);
        }catch (PetbookServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/users/{userName}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByNameUser(@PathVariable(name = "userName") String userName) {
        try {
            return new ResponseEntity<>(us.getUserByNameUser(userName), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/users/changeUser", method = RequestMethod.POST)
    public ResponseEntity<?> changeUsuario(@RequestBody User user){
        try {
            us.ediitUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }
}