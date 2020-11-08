package edu.eci.arsw.petbook.controllers;

import edu.eci.arsw.petbook.model.Donation;
import edu.eci.arsw.petbook.services.IDonationServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class DonationAPIController {
    @Autowired
    IDonationServices ds;

    @RequestMapping(path = "/donations/newDonation", method = RequestMethod.POST)
    public ResponseEntity<?> postDonation(@RequestBody Donation donation){
        try {
            ds.addDonation(donation);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, null);
        }
    }

    @RequestMapping(path = "/donations", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDonations(){
        try{
            return new ResponseEntity<>(ds.getAllDonations(),HttpStatus.ACCEPTED);
        }catch (PetbookServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "person/donations/{iduser}", method = RequestMethod.GET)
    public ResponseEntity<?> getDonationsXPerson(@PathVariable(name = "iduser") int iduser) {
        try {
            return new ResponseEntity<>(ds.getDonationsXPerson(iduser), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "refuge/donations/{idrefuge}", method = RequestMethod.GET)
    public ResponseEntity<?> getDonationsXRefuge(@PathVariable(name = "idrefuge") int idrefuge) {
        try {
            return new ResponseEntity<>(ds.getDonationsXRefuge(idrefuge), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "event/donations/{idevent}", method = RequestMethod.GET)
    public ResponseEntity<?> getDonationsXEvent(@PathVariable(name = "idevent") int idevent) {
        try {
            return new ResponseEntity<>(ds.getDonationsXEvent(idevent), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
