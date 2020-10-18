package edu.eci.arsw.petbook.persistence;

import edu.eci.arsw.petbook.model.Participant;
import edu.eci.arsw.petbook.model.User;

import java.util.List;

public interface IUserPersistence {

    void addUser(User user) throws PetbookPersistenceException;

    void setUser(User user)throws PetbookPersistenceException;

    List<User> getAllUsers()throws PetbookPersistenceException;

    User getUserByNameUser(String nameUser)throws PetbookPersistenceException;

    void changeUser(User user)throws PetbookPersistenceException;

    void saveUsuario(User usuario)throws PetbookPersistenceException;

    void  saveParticiapnt(Participant participant) throws  PetbookPersistenceException;

    void asistirEvento(int idevent,int iduser)throws PetbookPersistenceException;

    void deleteParticipById(Participant participant)throws PetbookPersistenceException;

    List<Participant> getAllParticipants()throws PetbookPersistenceException;

    User getUserById(int idUser)throws PetbookPersistenceException;
}

