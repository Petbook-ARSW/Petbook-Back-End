package edu.eci.arsw.petbook.services;
import edu.eci.arsw.petbook.model.Pet;
import edu.eci.arsw.petbook.model.User;


import java.util.List;

public interface IPetServices {

    void addUser(Pet pet) throws PetbookServicesException;

    List<Pet> getAllPets() throws PetbookServicesException;

    List<Pet> getPetsByIdPerson(int personId) throws PetbookServicesException;

    void editPet(int petId,Pet pet) throws PetbookServicesException;
}

