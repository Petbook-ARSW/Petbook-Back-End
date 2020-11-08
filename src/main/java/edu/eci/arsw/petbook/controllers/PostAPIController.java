package edu.eci.arsw.petbook.controllers;

import edu.eci.arsw.petbook.services.IPostServices;
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
        ps.addPost(file, idUser, description);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPosts(){
        return new ResponseEntity<>(ps.getAllPosts(), HttpStatus.ACCEPTED);
    }

}
