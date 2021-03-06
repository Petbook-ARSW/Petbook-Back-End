package edu.eci.arsw.petbook.service;

import edu.eci.arsw.petbook.model.*;

import java.util.List;

public interface IUserServices {

    void addUser(User user) throws PetbookServicesException;

    List<User> getAllUsers() throws PetbookServicesException;

    User getUserByNameUser(String nameUser) throws PetbookServicesException;

    void ediitUser(User user) throws PetbookServicesException;

    void asistirEvento(int idevent,int iduser)throws PetbookServicesException;

    void deleteParticipById(int idevent, int iduser)throws PetbookServicesException;

    List<Participant> getAllParticipants()throws PetbookServicesException;

    User getUserById(int idUser)throws PetbookServicesException;

    void addNotification (Notification notification) throws PetbookServicesException;

    List<Notification> getNotificationsByUser ( int idUser) throws PetbookServicesException;
    
    void darLike(int idpost,int iduser)throws PetbookServicesException;

    void removeLikeById(int idpost, int iduser)throws PetbookServicesException;

    void addComment(Coment comment)throws  PetbookServicesException;

}
