package edu.eci.arsw.petbook.services.impl;

import edu.eci.arsw.petbook.model.Participant;
import edu.eci.arsw.petbook.model.User;
import edu.eci.arsw.petbook.persistence.IUserPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.services.IUserServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServices implements IUserServices {

    @Autowired
    IUserPersistence up;

    public UserServices(){

    }

    @Override
    public void addUser(User user) throws PetbookServicesException {
        try{
            up.addUser(user);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }


    @Override
    public void asistirEvento(int idevent,int iduser) throws PetbookServicesException {
        try {
            up.asistirEvento(idevent,iduser);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());

        }
    }

    @Override
    public void deleteParticipById(Participant participant) throws PetbookServicesException {
        try {
            up.deleteParticipById(participant);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Participant> getAllParticipants() throws PetbookServicesException {
        try{
            return up.getAllParticipants();
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public User getUserById(int idUser) throws PetbookServicesException {
        try{
            return up.getUserById(idUser);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void setUser(User user) throws PetbookServicesException {
        try{
            up.setUser(user);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() throws PetbookServicesException {
        try{
            return up.getAllUsers();
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public User getUserByNameUser(String userName) throws PetbookServicesException {
        try{
            return up.getUserByNameUser(userName);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void ediitUser(User user) throws PetbookServicesException {
        try{
            up.changeUser(user);
        }catch(PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }


}
