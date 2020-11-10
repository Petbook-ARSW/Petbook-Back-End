package edu.eci.arsw.petbook.persistence;

import edu.eci.arsw.petbook.model.Like;
import edu.eci.arsw.petbook.model.Post;
import edu.eci.arsw.petbook.model.User;

import java.util.List;

public interface IPostPersistence {

    void addPost(Post post);

    List<Post> getAllPosts() throws PetbookPersistenceException;

    void deletePost(int idPost)throws PetbookPersistenceException;

    void updatePost(int idPost, Post post)throws PetbookPersistenceException;

    Post getPostById(int postId)throws PetbookPersistenceException;

    public List<Like> getAllLikes(int idpost)throws PetbookPersistenceException;
}
