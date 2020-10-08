package edu.eci.arsw.petbook.services;

import edu.eci.arsw.petbook.model.User;
import java.util.List;

public interface IUserServices {

    void addUser(User user) throws PetbookServicesException;

    void setUser(User user) throws PetbookServicesException;

    List<User> getAllUsers() throws PetbookServicesException;

    User getUserByNameUser(String nameUser) throws PetbookServicesException;

}
