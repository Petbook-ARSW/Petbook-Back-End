package edu.eci.arsw.petbook.persistence.cache.impl;

import edu.eci.arsw.petbook.model.Post;
import edu.eci.arsw.petbook.persistence.cache.IPetbookCache;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class PetbookCache implements IPetbookCache {

    public static final String POST_KEY = "edu:eci:arsw:petbook:post";

    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public PetbookCache(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.expire("Petbook-cache", 1, TimeUnit.MINUTES);
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    @Override
    public boolean exists(int postId) {
        return get(postId) != null;
    }

    @Override
    public Post get(int postId) {
        return (Post) hashOperations.get("Petbook-cache", getKey(postId));
    }

    @Override
    public List<Post> getAll() {
        return (List<Post>) hashOperations.values("Petbook-cache");
    }

    @Override
    public void put(Post payload) {
        hashOperations.put("Petbook-cache", getKey(payload.getId()), payload);
    }

    private String getKey(int postId) {
        return String.format("%s:%s", POST_KEY, postId);
    }

}
