package edu.eci.arsw.petbook.persistence;
import edu.eci.arsw.petbook.model.Pet;

import java.util.List;

public interface IPetPersistence {
    void addUser(Pet pet) throws PetbookPersistenceException;

    List<Pet> getAllPets()throws PetbookPersistenceException;

    List<Pet> getPetsByIdPerson(int personId)throws PetbookPersistenceException;

    void editPet(int id, Pet pet)throws PetbookPersistenceException;

    void save(Pet pet)throws PetbookPersistenceException;

    Pet getPetById(int id) throws  PetbookPersistenceException;


    void removePetId(int id)throws  PetbookPersistenceException;
}