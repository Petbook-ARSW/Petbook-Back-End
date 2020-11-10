package edu.eci.arsw.petbook.services;

import edu.eci.arsw.petbook.model.Like;
import edu.eci.arsw.petbook.model.Post;
import edu.eci.arsw.petbook.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPostServices {

    void addPost(MultipartFile file, int idUser, String description) throws PetbookServicesException;

    List<Post> getAllPosts() throws PetbookServicesException;

    void deletePost(int idPost) throws PetbookServicesException;

    void updatePost(int postId, Post post) throws PetbookServicesException;

    Post getPostById(int postId)throws PetbookServicesException;
    
    List<Like> getAllLikes(int idpost)throws PetbookServicesException;
    
    User getUserByLike(int idUser, int idpost) throws PetbookServicesException;
}
