package edu.eci.arsw.petbook.persistence.cache;

import edu.eci.arsw.petbook.model.Post;

import java.util.List;

public interface IPetbookCache {

    boolean exists(int postId);

    Post get(int postId);

    List<Post> getAll();

    void put(Post payload);

}
