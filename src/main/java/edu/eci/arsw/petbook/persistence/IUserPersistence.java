package edu.eci.arsw.petbook.persistence;

import edu.eci.arsw.petbook.model.User;

import java.util.List;

public interface IUserPersistence {

    void addUser(User user) throws PetbookPersistenceException;

    void setUser(User user)throws PetbookPersistenceException;

    List<User> getAllUsers()throws PetbookPersistenceException;

    User getUserByNameUser(String nameUser)throws PetbookPersistenceException;

}

