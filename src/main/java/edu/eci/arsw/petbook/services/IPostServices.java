package edu.eci.arsw.petbook.services;

import edu.eci.arsw.petbook.model.Post;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPostServices {

    void addPost(MultipartFile file, int idUser, String description);

    List<Post> getAllPosts();
}