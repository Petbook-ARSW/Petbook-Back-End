package edu.eci.arsw.petbook.persistence.impl;

import edu.eci.arsw.petbook.model.Post;
import edu.eci.arsw.petbook.persistence.IPostPersistence;
import edu.eci.arsw.petbook.persistence.repo.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostPersistenceImpl implements IPostPersistence {

    @Autowired
    IPostRepo pr;

    @Override
    public void addPost(Post post) {
        pr.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return pr.findAll();
    }

}
