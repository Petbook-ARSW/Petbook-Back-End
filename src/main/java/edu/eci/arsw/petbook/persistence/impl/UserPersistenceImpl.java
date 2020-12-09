package edu.eci.arsw.petbook.persistence.impl;

import edu.eci.arsw.petbook.model.*;
import edu.eci.arsw.petbook.persistence.IUserPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.persistence.repo.*;
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
    IComentRepo cr;

    @Autowired
    IParticipantRepo pr;
    
    @Autowired
    ILikeRepo lr;

    @Autowired
    IPostRepo pt;

    @Autowired
    INotificationRepo nr;

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
        User user = ur.findById(idUser).get();
        if (user.equals(null)){
            throw new PetbookPersistenceException("User not found");
        }
        return user;
    }

    @Override
    public void addNotification(Notification notification) throws PetbookPersistenceException {
        nr.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByUser(int idUser) throws PetbookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from notification where  iduser=? order by datehour desc",Notification.class);
            query.setParameter(1, idUser);
            return query.getResultList();
        }catch(Exception e){
            throw new PetbookPersistenceException("Failed to remove pet");
        }
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
        User temp = ur.findById(user.getId()).get();
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
    public void saveUsuario(User usuario)throws PetbookPersistenceException {
        ur.save(usuario);
    }

    @Override
    public void saveParticiapnt(Participant participant) throws PetbookPersistenceException {
        pr.save(participant);
    }
    
    @Override
    public void saveLike(Like like) throws PetbookPersistenceException {
        lr.save(like);
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

    @Override
    public void darLike(int idpost, int iduser) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("insert into likes (iduser,idevent) values (?,?)",Like.class);
        query.setParameter(1, iduser).setParameter(2, idpost);
        Like temp = new Like();
        temp.setIdpost(idpost);
        temp.setIduser(iduser);
        saveLike(temp);
    }

    @Override
    public void removeLikeById(int idpost, int iduser) throws PetbookPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from likes where  idpost=? and iduser=?",Like.class);
            query.setParameter(1, idpost).setParameter(2, iduser);
            lr.delete((Like) query.getSingleResult());
        }catch(Exception e){
            throw new PetbookPersistenceException("Failed to remove like");
        }
    }

    @Override
    public void addComment(Coment comment) throws PetbookPersistenceException {
        try {
            cr.save(comment);
        }catch(Exception ex){
            throw new PetbookPersistenceException("Failed to create user");
        }
    }
}