package edu.eci.arsw.petbook.services.impl;

import edu.eci.arsw.petbook.model.Pet;
import edu.eci.arsw.petbook.persistence.IPetPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.services.IPetServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PetServices implements IPetServices{

    @Autowired
    IPetPersistence pts;

    public PetServices(){}


    @Override
    public void addUser(Pet pet) throws PetbookServicesException {
        try{
            pts.addUser(pet);
        }catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Pet> getAllPets() throws PetbookServicesException {
        try{
            return pts.getAllPets();
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Pet> getPetsByIdPerson(int personId) throws PetbookServicesException {
        try{
            return pts.getPetsByIdPerson(personId);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public Pet getPetById(int id) throws PetbookServicesException {
        try{
            return pts.getPetById(id);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void editPet(int id,Pet pet) throws PetbookServicesException {
        try{
            pts.editPet(id,pet);
        }catch(PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void removePetId(int id) throws PetbookServicesException {
        try {
            pts.removePetId(id);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }


}
