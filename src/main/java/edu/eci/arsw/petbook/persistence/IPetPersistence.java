package edu.eci.arsw.petbook.persistence;
import java.util.List;
import edu.eci.arsw.petbook.model.Pet;
import edu.eci.arsw.petbook.model.User;

public interface IPetPersistence {
    void addUser(Pet pet) throws PetbookPersistenceException;

    List<Pet> getAllPets()throws PetbookPersistenceException;

    List<Pet> getPetsByIdPerson(int personId)throws PetbookPersistenceException;

    void editPet(int id, Pet pet)throws PetbookPersistenceException;

    void save(Pet pet)throws PetbookPersistenceException;
}