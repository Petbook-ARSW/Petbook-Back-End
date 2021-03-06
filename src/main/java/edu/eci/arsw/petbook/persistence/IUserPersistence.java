package edu.eci.arsw.petbook.persistence;

import edu.eci.arsw.petbook.model.*;

import java.util.List;

public interface IUserPersistence {

    void addUser(User user) throws PetbookPersistenceException;

    List<User> getAllUsers()throws PetbookPersistenceException;

    User getUserByNameUser(String nameUser)throws PetbookPersistenceException;

    void changeUser(User user)throws PetbookPersistenceException;

    void saveUsuario(User usuario)throws PetbookPersistenceException;

    void  saveParticiapnt(Participant participant) throws  PetbookPersistenceException;

    void asistirEvento(int idevent,int iduser)throws PetbookPersistenceException;

    void deleteParticipById(int idevent, int iduser)throws PetbookPersistenceException;

    List<Participant> getAllParticipants()throws PetbookPersistenceException;

    User getUserById(int idUser)throws PetbookPersistenceException;

    void addNotification(Notification notification)throws PetbookPersistenceException;

    List<Notification> getNotificationsByUser(int idUser)throws PetbookPersistenceException;

    void darLike(int idpost, int iduser)throws PetbookPersistenceException;
    
    void  saveLike(Like like) throws  PetbookPersistenceException;
    
    void removeLikeById(int idpost, int iduser)throws PetbookPersistenceException;

    void addComment(Coment comment)throws PetbookPersistenceException;
}

