package edu.eci.arsw.petbook.persistence.impl;

import edu.eci.arsw.petbook.model.Pet;
import edu.eci.arsw.petbook.persistence.IPetPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.persistence.repo.IPetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class PetPersistenceImpl implements IPetPersistence {

    @Autowired
    IPetRepo ptr;

    @PersistenceContext
    EntityManager entityManager;


    public PetPersistenceImpl() {}


    @Override
    public void addUser(Pet pet) throws PetbookPersistenceException {
        try {
            ptr.save(pet);
        }catch(Exception ex){
            throw new PetbookPersistenceException("Failed to create user");
        }
    }

    @Override
    public List<Pet> getAllPets() throws PetbookPersistenceException {
        if(ptr.count() == 0){
            throw new PetbookPersistenceException("Pets not found");
        }
        return ptr.findAll();
    }

    @Override
    public List<Pet> getPetsByIdPerson(int personId) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from pet where idowner=?", Pet.class);
        query.setParameter(1, personId);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Pets not found");
        }
        return query.getResultList();
    }


    @Override
    public Pet getPetById(int id) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from pet where id=?", Pet.class);
        query.setParameter(1, id);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("Pets not found");
        }
        return (Pet) query.getSingleResult();
    }

    @Override
    public void removePetId(int id) throws PetbookPersistenceException {
        try {
            ptr.deleteById(id);
        }catch(Exception e){
            throw new PetbookPersistenceException("Failed to remove pet");
        }
    }


    @Override
    public void editPet(int id, Pet pet) throws PetbookPersistenceException {
        Pet temp = ptr.findById(id).get();
        if (!pet.getInformation().equals("")){
            temp.setInformation(pet.getInformation());
        }
        save(temp);
    }

    @Override
    public void save(Pet pet) throws PetbookPersistenceException {
        ptr.save(pet);
    }



}
