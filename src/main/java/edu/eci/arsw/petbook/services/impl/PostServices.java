package edu.eci.arsw.petbook.services.impl;

import edu.eci.arsw.petbook.model.Post;
import edu.eci.arsw.petbook.persistence.IPostPersistence;
import edu.eci.arsw.petbook.services.IPostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class PostServices implements IPostServices {

    @Autowired
    IPostPersistence pp;

    @Override
    public void addPost(MultipartFile file, int idUser, String description) {
        try {
            byte [] byteArr = file.getBytes();
            Post post = new Post(idUser, byteArr, description, new Date());
            System.out.println(byteArr);
            pp.addPost(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAllPosts() {
        return pp.getAllPosts();
    }

}
