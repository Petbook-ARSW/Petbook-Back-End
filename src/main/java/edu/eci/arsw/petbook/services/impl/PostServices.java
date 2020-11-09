package edu.eci.arsw.petbook.services.impl;

import edu.eci.arsw.petbook.model.Post;
import edu.eci.arsw.petbook.persistence.IPostPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.services.IPostServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.List;

@Service
public class PostServices implements IPostServices {

    @Autowired
    IPostPersistence pp;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addPost(MultipartFile file, int idUser, String description) throws PetbookServicesException {
        try {
            byte [] byteArr = file.getBytes();
            Post post = new Post(idUser, byteArr, description);
            pp.addPost(post);
        } catch (IOException e) {
            throw new PetbookServicesException("Fail to add post");
        }
    }

    @Override
    public List<Post> getAllPosts() throws PetbookServicesException {
        try {
            return pp.getAllPosts();
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void deletePost(int idPost) throws PetbookServicesException {
        try {
            pp.deletePost(idPost);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public void updatePost(int idPost, Post post) throws PetbookServicesException {
        try {
            pp.updatePost(idPost, post);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }

    @Override
    public Post getPostById(int postId) throws PetbookServicesException {
        try {
            return pp.getPostById(postId);
        } catch (PetbookPersistenceException e) {
            throw new PetbookServicesException(e.getMessage());
        }
    }
}
