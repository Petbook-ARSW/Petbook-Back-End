package edu.eci.arsw.petbook.persistence;

import edu.eci.arsw.petbook.model.Donation;
import java.util.List;

public interface IDonationPersistence {
    void addDonation(Donation donation)throws PetbookPersistenceException;
    
    List<Donation> getAllDonations()throws PetbookPersistenceException;
    
    List<Donation> getDonationsXPerson(int iduser) throws PetbookPersistenceException;
    
    List<Donation> getDonationsXRefuge(int idrefuge) throws PetbookPersistenceException;
    
    List<Donation> getDonationsXEvent(int idevent) throws PetbookPersistenceException;
}
