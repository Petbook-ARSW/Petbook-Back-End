package edu.eci.arsw.petbook.controller;

import edu.eci.arsw.petbook.model.Coment;
import edu.eci.arsw.petbook.model.User;
import edu.eci.arsw.petbook.service.IUserServices;
import edu.eci.arsw.petbook.service.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "users/participInEnvent/{idevent}/{iduser}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeParticipant(@PathVariable(name = "idevent") int idevent, @PathVariable(name = "iduser") int iduser) {
        try {
            us.deleteParticipById(idevent, iduser);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/users/participInEnvent", method = RequestMethod.GET)
    public ResponseEntity<?> getAllParticipants(){
        try{
            return new ResponseEntity<>(us.getAllParticipants(),HttpStatus.ACCEPTED);
        }catch (PetbookServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
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

    @RequestMapping(path = "/users/id/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable(name = "idUser") int idUser) {
        try {
            return new ResponseEntity<>(us.getUserById(idUser), HttpStatus.ACCEPTED);
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
    
    @RequestMapping(path = "/users/LikeToPost/{idpost}/{iduser}", method = RequestMethod.POST)
    public ResponseEntity<?> postLike(@PathVariable(name = "idpost") int idpost,@PathVariable(name = "iduser") int iduser){
        try {
            us.darLike(idpost,iduser);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }
    
    @RequestMapping(path = "users/DislikeToPost/{idpost}/{iduser}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeLike(@PathVariable(name = "idpost") int idpost, @PathVariable(name = "iduser") int iduser) {
        try {
            us.removeLikeById(idpost, iduser);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(path = "/users/addComment", method = RequestMethod.POST)
    public ResponseEntity<?> comment(@RequestBody Coment comment){
        try {
            us.addComment(comment);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }



}