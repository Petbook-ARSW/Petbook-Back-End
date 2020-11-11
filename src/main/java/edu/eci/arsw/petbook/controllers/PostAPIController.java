package edu.eci.arsw.petbook.controllers;

import edu.eci.arsw.petbook.model.Post;
import edu.eci.arsw.petbook.services.IPostServices;
import edu.eci.arsw.petbook.services.PetbookServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
public class PostAPIController {

    @Autowired
    IPostServices ps;

    @RequestMapping(path = "/posts", method = RequestMethod.POST)
    public ResponseEntity<?> newPost(@RequestParam("file") MultipartFile file, @RequestParam("idUser") int idUser, @RequestParam("description") String description){
        try {
            ps.addPost(file, idUser, description);
        } catch (PetbookServicesException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPosts(){
        try {
            return new ResponseEntity<>(ps.getAllPosts(), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/posts/{idPost}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePost(@PathVariable(name = "idPost") int idPost){
        try {
            ps.deletePost(idPost);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (PetbookServicesException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/posts/{postId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePost(@PathVariable(name = "postId") int postId, @RequestBody Post post){
        try {
            ps.updatePost(postId, post);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(path = "/posts/{postId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPostById(@PathVariable(name = "postId") int postId){
        try {
            return new ResponseEntity<>(ps.getPostById(postId), HttpStatus.CREATED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(path = "/posts/{postid}/likes", method = RequestMethod.GET)
    public ResponseEntity<?> getLikesXPostId(@PathVariable(name = "postid") int postid){
        try{
            return new ResponseEntity<>(ps.getAllLikes(postid),HttpStatus.ACCEPTED);
        }catch (PetbookServicesException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/post/comments/{postid}", method = RequestMethod.GET)
    public ResponseEntity<?> getCommentsById(@PathVariable(name = "postid") int postid) {
        try {
            return new ResponseEntity<>(ps.getCommentsByIdPost(postid), HttpStatus.ACCEPTED);
        } catch (PetbookServicesException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
