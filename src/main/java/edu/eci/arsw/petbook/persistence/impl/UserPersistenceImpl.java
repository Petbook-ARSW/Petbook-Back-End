package edu.eci.arsw.petbook.persistence.impl;

import edu.eci.arsw.petbook.model.Participant;
import edu.eci.arsw.petbook.model.User;
import edu.eci.arsw.petbook.persistence.IUserPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.persistence.repo.IParticipantRepo;
import edu.eci.arsw.petbook.persistence.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserPersistenceImpl implements IUserPersistence {

    @Autowired
    IUserRepo ur;

    @Autowired
    IParticipantRepo pr;

    @PersistenceContext
    EntityManager entityManager;


    public UserPersistenceImpl() {}

    @Override
    public void addUser(User user) throws PetbookPersistenceException {
        try {
            ur.save(user);
        }catch(Exception ex){
            throw new PetbookPersistenceException("Failed to create user");
        }
    }

    @Override
    public void asistirEvento(int idevent,int iduser) throws PetbookPersistenceException {
        //insert into companyevent (eventname, isDonaton, address, eventdate, eventhour, information, hostcompany) values ('Jornada de vacunación', true, 'cll 55a No343c - 5', '2020-12-16', '13:00', 'sin info', 4);
        Query query = entityManager.createNativeQuery("insert into participants (iduser,idevent) values (?,?)",Participant.class);
        query.setParameter(1, iduser).setParameter(2, idevent);
        Participant temp = new Participant();
        temp.setIdevent(idevent);
        temp.setIduser(iduser);
        saveParticiapnt(temp);
    }

    @Override
    public void deleteParticipById(int idevent, int iduser) throws PetbookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from participants where  idevent=? and iduser=?",Participant.class);
            query.setParameter(1, idevent).setParameter(2, iduser);
            pr.delete((Participant) query.getSingleResult());
        }catch(Exception e){
            throw new PetbookPersistenceException("Failed to remove pet");
        }
    }

    @Override
    public List<Participant> getAllParticipants() throws PetbookPersistenceException {
        if(pr.count() == 0){
            throw new PetbookPersistenceException("Participants not found");
        }
        return pr.findAll();
    }

    @Override
    public User getUserById(int idUser) throws PetbookPersistenceException {
        User user = ur.findOne(idUser);
        if (user.equals(null)){
            throw new PetbookPersistenceException("User not found");
        }
        return user;
    }
    
    @Override
    public void setUser(User user) throws PetbookPersistenceException {
        //falta implementar
    }

    @Override
    public List<User> getAllUsers() throws PetbookPersistenceException {
        if(ur.count() == 0){
            throw new PetbookPersistenceException("Users not found");
        }
        return ur.findAll();
    }


    @Override
    public void changeUser(User user) throws PetbookPersistenceException {
        User temp = ur.findOne(user.getId());
        if (user.getPasword()!=""){
            temp.setPasword(user.getPasword());
        }
        if (!user.getNumberPhone().equals("")){
            temp.setNumberPhone(user.getNumberPhone());
        }
        if (!user.getMail().equals("")){
            temp.setMail(user.getMail());
        }
        if (!user.getInformation().equals("")){
            temp.setInformation(user.getInformation());
        }
        saveUsuario(temp);
    }

    @Override
    public void saveUsuario(User usuario) {
        ur.save(usuario);
    }

    @Override
    public void saveParticiapnt(Participant participant) throws PetbookPersistenceException {
        pr.save(participant);
    }

    @Override
    public User getUserByNameUser(String userName) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from petbookuser where username=?",User.class);
        query.setParameter(1, userName);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("User not found");
        }
        return (User) query.getSingleResult();
    }


}