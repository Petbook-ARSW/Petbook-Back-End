package edu.eci.arsw.petbook.persistence.impl;

import edu.eci.arsw.petbook.model.User;
import edu.eci.arsw.petbook.persistence.IUserPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
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

    @PersistenceContext
    EntityManager entityManager;

    public UserPersistenceImpl() {

    }

    @Override
    public void addUser(User user) throws PetbookPersistenceException {
        try {
            ur.save(user);
        }catch(Exception ex){
            throw new PetbookPersistenceException("Failed to create user");
        }
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
    public User getUserByNameUser(String userName) throws PetbookPersistenceException {
        Query query = entityManager.createNativeQuery("select * from petbookuser where username=?",User.class);
        query.setParameter(1, userName);
        if (query.getResultList().size() == 0) {
            throw new PetbookPersistenceException("User not found");
        }
        return (User) query.getSingleResult();
    }

}
