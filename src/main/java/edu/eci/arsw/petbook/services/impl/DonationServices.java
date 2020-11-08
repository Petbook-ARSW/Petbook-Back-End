package edu.eci.arsw.petbook.services.impl;

import edu.eci.arsw.petbook.model.Donation;
import edu.eci.arsw.petbook.persistence.IDonationPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.services.IDonationServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class DonationServices implements IDonationServices {
    @Autowired
    IDonationPersistence dp;

    @Override
    public void addDonation(Donation donation) throws PetbookServicesException {
        try {
            dp.addDonation(donation);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Donation> getAllDonations() throws PetbookServicesException {
        try {
            return dp.getAllDonations();
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Donation> getDonationsXPerson(int iduser) throws PetbookServicesException {
        try{
            return dp.getDonationsXPerson(iduser);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Donation> getDonationsXRefuge(int idrefuge) throws PetbookServicesException {
        try{
            return dp.getDonationsXRefuge(idrefuge);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Donation> getDonationsXEvent(int idevent) throws PetbookServicesException {
        try{
            return dp.getDonationsXEvent(idevent);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }
}
