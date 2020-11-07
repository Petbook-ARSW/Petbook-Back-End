package edu.eci.arsw.petbook.persistence.repo;

import edu.eci.arsw.petbook.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Integer> {
}
