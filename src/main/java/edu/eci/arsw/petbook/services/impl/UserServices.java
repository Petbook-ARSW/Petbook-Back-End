package edu.eci.arsw.petbook.services.impl;

import edu.eci.arsw.petbook.model.Notification;
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
    public void deleteParticipById(int idevent, int iduser) throws PetbookServicesException {
        try {
            up.deleteParticipById(idevent, iduser);
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
    public void addNotification(Notification notification) throws PetbookServicesException {
        try{
            up.addNotification(notification);
        }catch (PetbookPersistenceException e){
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public List<Notification> getNotificationsByUser(int idUser) throws PetbookServicesException {
        try{
            return up.getNotificationsByUser(idUser);
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

    @Override
    public void darLike(int idpost, int iduser) throws PetbookServicesException {
        try {
            up.darLike(idpost,iduser);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void removeLikeById(int idpost, int iduser) throws PetbookServicesException {
        try {
            up.removeLikeById(idpost, iduser);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }
}
