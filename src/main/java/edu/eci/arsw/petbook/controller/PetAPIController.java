package edu.eci.arsw.petbook.controller;


import edu.eci.arsw.petbook.model.Pet;
import edu.eci.arsw.petbook.service.IPetServices;
import edu.eci.arsw.petbook.service.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class PetAPIController {

    @Autowired
    IPetServices pts;

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


    @RequestMapping(path = "/pets/pet/{petId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPetById(@PathVariable(name = "petId") int petId) {
        try {
            return new ResponseEntity<>(pts.getPetById(petId), HttpStatus.ACCEPTED);
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

    @RequestMapping(path = "/pets/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removePet(@PathVariable(name = "id") int id) {
        try {
            pts.removePetId(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
