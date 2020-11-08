package edu.eci.arsw.petbook.services;

import edu.eci.arsw.petbook.model.Donation;
import java.util.List;

public interface IDonationServices {
    
    void addDonation(Donation donation)throws PetbookServicesException;
    
    List<Donation> getAllDonations()throws PetbookServicesException;
    
    List<Donation> getDonationsXPerson(int iduser) throws PetbookServicesException;
    
    List<Donation> getDonationsXRefuge(int idrefuge) throws PetbookServicesException;
    
    List<Donation> getDonationsXEvent(int idevent) throws PetbookServicesException;
}
