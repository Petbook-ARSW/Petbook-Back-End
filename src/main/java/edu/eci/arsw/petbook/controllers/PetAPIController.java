package edu.eci.arsw.petbook.controllers;


import edu.eci.arsw.petbook.model.Pet;
import edu.eci.arsw.petbook.model.User;
import edu.eci.arsw.petbook.services.IPetServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PetAPIController {

    @Autowired
    IPetServices pts;

    //@RequestMapping(method = RequestMethod.GET)
    //public ResponseEntity<?> getResources(){
    //    return new ResponseEntity<>(null,HttpStatus.ACCEPTED);
    //}

    @RequestMapping(path = "/pets/newPet", method = RequestMethod.POST)
    public ResponseEntity<?> postPet(@RequestBody Pet pet){
        try {
            pts.addUser(pet);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }


    @RequestMapping(path = "/pets", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPets(){
        try{
            return new ResponseEntity<>(pts.getAllPets(),HttpStatus.ACCEPTED);
        }catch (PetbookServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/pets/{personId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPetsByIdPerson(@PathVariable(name = "personId") int personId) {
        try {
            return new ResponseEntity<>(pts.getPetsByIdPerson(personId), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/pets/changePet/{petId}", method = RequestMethod.POST)
    public ResponseEntity<?> changeUsuario(@PathVariable(name = "petId") int petId,@RequestBody Pet pet){
        try {
            pts.editPet(petId,pet);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }


}
