package edu.eci.arsw.petbook.persistence.impl;

import edu.eci.arsw.petbook.model.Post;
import edu.eci.arsw.petbook.persistence.IPostPersistence;
import edu.eci.arsw.petbook.persistence.PetbookPersistenceException;
import edu.eci.arsw.petbook.persistence.repo.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PostPersistenceImpl implements IPostPersistence {

    @Autowired
    IPostRepo pr;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addPost(Post post) {
        pr.save(post);
    }

    @Override
    public List<Post> getAllPosts() throws PetbookPersistenceException  {
        try {
            Query query = entityManager.createNativeQuery("select * from post order by uploaddate desc", Post.class);
            return query.getResultList();
        }catch(Exception e){
            throw new PetbookPersistenceException("Posts not found");
        }
    }

    @Override
    public void deletePost(int idPost) throws PetbookPersistenceException {
        try {
            pr.delete(idPost);
        } catch (Exception ex) {
            throw new PetbookPersistenceException("Failed to delete post");
        }
    }

    @Override
    public void updatePost(int idPost, Post post) throws PetbookPersistenceException {
        Post newPost = pr.findOne(idPost);
        newPost.setDescription(post.getDescription());
        pr.save(newPost);
    }

}
