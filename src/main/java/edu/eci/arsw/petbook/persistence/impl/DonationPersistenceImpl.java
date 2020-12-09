package edu.eci.arsw.petbook.persistence.impl;

import edu.eci.arsw.petbook.model.Donation;
import edu.eci.arsw.petbook.persistence.IDonationPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.persistence.repo.IDonationRepo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DonationPersistenceImpl implements IDonationPersistence{
    
    @Autowired
    IDonationRepo dr;
    
    @PersistenceContext
    EntityManager entityManager;
    
    public DonationPersistenceImpl(){}
    
    @Override
    public void addDonation(Donation donation) throws PetbookPersistenceException {
        try {
            dr.save(donation);
        }catch(Exception e){
            throw new PetbookPersistenceException("Failed to create donation");
        }
    }

    
    @Override
    public List<Donation> getAllDonations() throws PetbookPersistenceException {
        if(dr.count() == 0){
            throw new PetbookPersistenceException("Donations not found");
        }
        return dr.findAll();
    }

    @Override
    public List<Donation> getDonationsXPerson(int iduser) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from donation where iduser=?",Donation.class);
        query.setParameter(1, iduser);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Donations not found");
        }
        return query.getResultList();
    }

    @Override
    public List<Donation> getDonationsXRefuge(int idrefuge) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from donation where idrefuge=?",Donation.class);
        query.setParameter(1, idrefuge);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Donations not found");
        }
        return query.getResultList();
    }

    @Override
    public List<Donation> getDonationsXEvent(int idevent) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from donation where idevent=?",Donation.class);
        query.setParameter(1, idevent);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Donations not found");
        }
        return query.getResultList();
    }

    @Override
    public List<Donation> getValuesDonationsXEvent(int idevent) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from donation where idevent=?",Donation.class);
        query.setParameter(1, idevent);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Donations not found");
        }
        return query.getResultList();

    }
}
